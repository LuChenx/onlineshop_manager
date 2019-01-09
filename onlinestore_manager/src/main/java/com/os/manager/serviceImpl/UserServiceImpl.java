
package com.os.manager.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.os.manager.dao.SysConfigPriceMapper;
import com.os.manager.dao.SysConfigRoleAuthMapper;
import com.os.manager.dao.SysConfigRolePriceMapper;
import com.os.manager.dao.SysManagerUserAreaMapper;
import com.os.manager.dao.SysManagerUserBrandMapper;
import com.os.manager.dao.SysManagerUserMapper;
import com.os.manager.dao.SysManagerUserRepertoryMapper;
import com.os.manager.dao.SysManagerUserRoleMapper;
import com.os.manager.dbmodel.SysConfigPriceExample;
import com.os.manager.dbmodel.SysConfigRoleAuth;
import com.os.manager.dbmodel.SysConfigRoleAuthExample;
import com.os.manager.dbmodel.SysConfigRolePriceExample;
import com.os.manager.dbmodel.SysManagerUser;
import com.os.manager.dbmodel.SysManagerUserArea;
import com.os.manager.dbmodel.SysManagerUserAreaExample;
import com.os.manager.dbmodel.SysManagerUserAreaExample.Criteria;
import com.os.manager.dbmodel.SysManagerUserBrand;
import com.os.manager.dbmodel.SysManagerUserBrandExample;
import com.os.manager.dbmodel.SysManagerUserExample;
import com.os.manager.dbmodel.SysManagerUserRepertory;
import com.os.manager.dbmodel.SysManagerUserRepertoryExample;
import com.os.manager.dbmodel.SysManagerUserRole;
import com.os.manager.dbmodel.SysManagerUserRoleExample;
import com.os.manager.request.AddUserRequest;
import com.os.manager.request.DeleteUserRequest;
import com.os.manager.request.UpdateUserRequest;
import com.os.manager.request.UserAuthRequest;
import com.os.manager.request.UserBaseInfoRequest;
import com.os.manager.request.UserListRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.UserAuthListResp;
import com.os.manager.response.UserBaseInfoResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.UserService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: UserServiceImpl
 * @Description:TODO(操作员管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午7:56:03
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("userService")
public class UserServiceImpl implements UserService
{
	private Logger		      logger = LogManager.getLogger(UserServiceImpl.class);
	@ Autowired
	SysManagerUserMapper	      sysManagerUserMapper;
	@ Autowired
	SysConfigPriceMapper	      sysConfigPriceMapper;
	@ Autowired
	SysConfigRolePriceMapper      sysConfigRolePriceMapper;
	@ Autowired
	SysManagerUserAreaMapper      sysManagerUserAreaMapper;
	@ Autowired
	SysManagerUserBrandMapper     sysManagerUserBrandMapper;
	@ Autowired
	SysManagerUserRepertoryMapper sysManagerUserRepertoryMapper;
	@ Autowired
	SysManagerUserRoleMapper      sysManagerUserRoleMapper;
	@ Autowired
	SysConfigRoleAuthMapper	      sysConfigRoleAuthMapper;

	@ Override
	public TableDataResp queryUserList(UserListRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysManagerUserExample example = new SysManagerUserExample();
			if(StringUtils.isNotEmpty(request.getSearchInfo()))
			{
				example.or().andAccountNameLike("%" + request.getSearchInfo() + "%");
				example.or().andUserNameLike("%" + request.getSearchInfo() + "%");
				example.or().andUserPhoneLike("%" + request.getSearchInfo() + "%");
			}
			List<SysManagerUser> users = sysManagerUserMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(users))
			{
				resp.setRows(JsonArrayUtils.conver(users));
				resp.setTotal(users.size());
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("操作员配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp addUser(AddUserRequest request)
	{
		BaseResp resp = new BaseResp();
		SysManagerUser record = new SysManagerUser();
		record.setId(UUID.randomUUID().toString());
		record.setAccountName(request.getAccount());
		record.setUserName(request.getUserName());
		record.setUserPhone(request.getUserPhone());
		record.setPassword(request.getPassword());
		record.setStatus(request.getStatus());
		record.setAreaStatus(request.getAreaStatus());
		record.setRepertoryStatus(request.getRepertoryStatus());
		record.setBrandStatus(request.getBrandStatus());
		//配置岗位信息
		String auth = request.getAuth();
		//查询岗位价格权限
		long priceAuthNum = sysConfigPriceMapper.countByExample(new SysConfigPriceExample());
		String[] roleArr = auth.split(",");
		List<SysManagerUserRole> roles = new ArrayList<>();
		for(int i = 0 ; i < roleArr.length ; i++)
		{
			if(StringUtils.isNotEmpty(roleArr[i]))
			{
				SysConfigRolePriceExample example = new SysConfigRolePriceExample();
				com.os.manager.dbmodel.SysConfigRolePriceExample.Criteria criteria = example
					.createCriteria();
				criteria.andRoleIdEqualTo(Long.valueOf(roleArr[i]));
				long rolePrice = sysConfigRolePriceMapper.countByExample(example);
				if(rolePrice == priceAuthNum)
				{
					//如果有所有价格权限
					record.setPriceStatus(true);
				}
				SysManagerUserRole role = new SysManagerUserRole();
				role.setRoleId(Long.valueOf(roleArr[i]));
				role.setManagerId(record.getId());
				roles.add(role);
			}
		}
		if(record.getPriceStatus() == null)
		{
			record.setPriceStatus(false);
		}
		sysManagerUserMapper.insert(record);
		sysManagerUserRoleMapper.insertList(roles);
		//保存区域权限
		if(StringUtils.isNotEmpty(request.getAreaAuth()))
		{
			List<SysManagerUserArea> areas = new ArrayList<>();
			String[] areaIds = request.getAreaAuth().split(",");
			for(int i = 0 ; i < areaIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(areaIds[i]))
				{
					SysManagerUserArea sysManagerUserArea = new SysManagerUserArea();
					sysManagerUserArea.setAreaId(Long.valueOf(areaIds[i]));
					sysManagerUserArea.setManagerId(record.getId());
					areas.add(sysManagerUserArea);
				}
			}
			sysManagerUserAreaMapper.insertList(areas);
		}
		//保存仓库权限
		if(StringUtils.isNotEmpty(request.getRepertoryAuth()))
		{
			List<SysManagerUserRepertory> repertories = new ArrayList<>();
			String[] repertoryIds = request.getRepertoryAuth().split(",");
			for(int i = 0 ; i < repertoryIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(repertoryIds[i]))
				{
					SysManagerUserRepertory sysManagerUserRepertory = new SysManagerUserRepertory();
					sysManagerUserRepertory.setRepertoryId(Long.valueOf(repertoryIds[i]));
					sysManagerUserRepertory.setManagerId(record.getId());
					repertories.add(sysManagerUserRepertory);
				}
			}
			sysManagerUserRepertoryMapper.insertList(repertories);
		}
		//保存品牌权限
		if(StringUtils.isNotEmpty(request.getBrandAuth()))
		{
			List<SysManagerUserBrand> brands = new ArrayList<>();
			String[] brandIds = request.getBrandAuth().split(",");
			for(int i = 0 ; i < brandIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(brandIds[i]))
				{
					SysManagerUserBrand sysManagerUserBrand = new SysManagerUserBrand();
					sysManagerUserBrand.setBrandId(Long.valueOf(brandIds[i]));
					sysManagerUserBrand.setManagerId(record.getId());
					brands.add(sysManagerUserBrand);
				}
			}
			sysManagerUserBrandMapper.insertList(brands);
		}
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp deleteUser(DeleteUserRequest request)
	{
		BaseResp resp = new BaseResp();
		//删除基本信息
		sysManagerUserMapper.deleteByPrimaryKey(request.getDeleteUserId());
		//删除其他配置 
		SysManagerUserAreaExample example = new SysManagerUserAreaExample();
		Criteria criteria = example.createCriteria();
		criteria.andManagerIdEqualTo(request.getDeleteUserId());
		sysManagerUserAreaMapper.deleteByExample(example);
		SysManagerUserRepertoryExample example2 = new SysManagerUserRepertoryExample();
		com.os.manager.dbmodel.SysManagerUserRepertoryExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andManagerIdEqualTo(request.getDeleteUserId());
		sysManagerUserRepertoryMapper.deleteByExample(example2);
		SysManagerUserBrandExample example3 = new SysManagerUserBrandExample();
		com.os.manager.dbmodel.SysManagerUserBrandExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andManagerIdEqualTo(request.getDeleteUserId());
		sysManagerUserBrandMapper.deleteByExample(example3);
		SysManagerUserRoleExample example4 = new SysManagerUserRoleExample();
		com.os.manager.dbmodel.SysManagerUserRoleExample.Criteria criteria4 = example4.createCriteria();
		criteria4.andManagerIdEqualTo(request.getDeleteUserId());
		sysManagerUserRoleMapper.deleteByExample(example4);
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	public UserAuthListResp queryUserAuthList(UserAuthRequest request)
	{
		UserAuthListResp resp = new UserAuthListResp();
		try
		{
			SysManagerUserAreaExample example = new SysManagerUserAreaExample();
			Criteria criteria = example.createCriteria();
			criteria.andManagerIdEqualTo(request.getUserId());
			List<SysManagerUserArea> sysManagerUserAreas = sysManagerUserAreaMapper
				.selectByExample(example);
			resp.setAreas(sysManagerUserAreas);
			SysManagerUserBrandExample example2 = new SysManagerUserBrandExample();
			com.os.manager.dbmodel.SysManagerUserBrandExample.Criteria criteria2 = example2
				.createCriteria();
			criteria2.andManagerIdEqualTo(request.getUserId());
			List<SysManagerUserBrand> sysManagerUserBrands = sysManagerUserBrandMapper
				.selectByExample(example2);
			resp.setBrands(sysManagerUserBrands);
			SysManagerUserRepertoryExample example3 = new SysManagerUserRepertoryExample();
			com.os.manager.dbmodel.SysManagerUserRepertoryExample.Criteria criteria3 = example3
				.createCriteria();
			criteria3.andManagerIdEqualTo(request.getUserId());
			List<SysManagerUserRepertory> sysManagerUserRepertories = sysManagerUserRepertoryMapper
				.selectByExample(example3);
			resp.setRepertorys(sysManagerUserRepertories);
			//查询用户角色
			SysManagerUserRoleExample example4 = new SysManagerUserRoleExample();
			com.os.manager.dbmodel.SysManagerUserRoleExample.Criteria criteria4 = example4.createCriteria();
			criteria4.andManagerIdEqualTo(request.getUserId());
			List<SysManagerUserRole> sysManagerUserRoles = sysManagerUserRoleMapper
				.selectByExample(example4);
			resp.setRoles(sysManagerUserRoles);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp updateUser(UpdateUserRequest request)
	{
		BaseResp resp = new BaseResp();
		//更新基本信息
		SysManagerUser record = new SysManagerUser();
		record.setId(request.getUserId());
		record.setAccountName(request.getAccount());
		record.setUserName(request.getUserName());
		record.setUserPhone(request.getUserPhone());
		record.setPassword(request.getPassword());
		record.setStatus(request.getStatus());
		record.setAreaStatus(request.getAreaStatus());
		record.setRepertoryStatus(request.getRepertoryStatus());
		record.setBrandStatus(request.getBrandStatus());
		//配置岗位信息
		String auth = request.getAuth();
		//查询岗位价格权限
		long priceAuthNum = sysConfigPriceMapper.countByExample(new SysConfigPriceExample());
		String[] roleArr = auth.split(",");
		List<SysManagerUserRole> roles = new ArrayList<>();
		for(int i = 0 ; i < roleArr.length ; i++)
		{
			if(StringUtils.isNotEmpty(roleArr[i]))
			{
				SysConfigRolePriceExample example = new SysConfigRolePriceExample();
				com.os.manager.dbmodel.SysConfigRolePriceExample.Criteria criteria = example
					.createCriteria();
				criteria.andRoleIdEqualTo(Long.valueOf(roleArr[i]));
				long rolePrice = sysConfigRolePriceMapper.countByExample(example);
				if(rolePrice == priceAuthNum)
				{
					//如果有所有价格权限
					record.setPriceStatus(true);
				}
				SysManagerUserRole role = new SysManagerUserRole();
				role.setRoleId(Long.valueOf(roleArr[i]));
				role.setManagerId(record.getId());
				roles.add(role);
			}
		}
		if(record.getPriceStatus() == null)
		{
			record.setPriceStatus(false);
		}
		sysManagerUserMapper.updateByPrimaryKey(record);
		//更新用户角色配置
		SysManagerUserRoleExample userRoleExample = new SysManagerUserRoleExample();
		com.os.manager.dbmodel.SysManagerUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
		criteria.andManagerIdEqualTo(request.getUserId());
		sysManagerUserRoleMapper.deleteByExample(userRoleExample);
		sysManagerUserRoleMapper.insertList(roles);
		//删除用户区域权限配置
		SysManagerUserAreaExample userAreaExample = new SysManagerUserAreaExample();
		com.os.manager.dbmodel.SysManagerUserAreaExample.Criteria criteria2 = userAreaExample.createCriteria();
		criteria2.andManagerIdEqualTo(request.getUserId());
		sysManagerUserAreaMapper.deleteByExample(userAreaExample);
		//删除用户仓库权限配置
		SysManagerUserRepertoryExample userRepertoryExample = new SysManagerUserRepertoryExample();
		com.os.manager.dbmodel.SysManagerUserRepertoryExample.Criteria criteria3 = userRepertoryExample
			.createCriteria();
		criteria3.andManagerIdEqualTo(request.getUserId());
		sysManagerUserRepertoryMapper.deleteByExample(userRepertoryExample);
		//删除用户品牌权限配置
		SysManagerUserBrandExample userBrandExample = new SysManagerUserBrandExample();
		com.os.manager.dbmodel.SysManagerUserBrandExample.Criteria criteria4 = userBrandExample
			.createCriteria();
		criteria4.andManagerIdEqualTo(request.getUserId());
		sysManagerUserBrandMapper.deleteByExample(userBrandExample);
		//添加新权限
		//保存区域权限
		if(StringUtils.isNotEmpty(request.getAreaAuth()))
		{
			List<SysManagerUserArea> areas = new ArrayList<>();
			String[] areaIds = request.getAreaAuth().split(",");
			for(int i = 0 ; i < areaIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(areaIds[i]))
				{
					SysManagerUserArea sysManagerUserArea = new SysManagerUserArea();
					sysManagerUserArea.setAreaId(Long.valueOf(areaIds[i]));
					sysManagerUserArea.setManagerId(record.getId());
					areas.add(sysManagerUserArea);
				}
			}
			sysManagerUserAreaMapper.insertList(areas);
		}
		//保存仓库权限
		if(StringUtils.isNotEmpty(request.getRepertoryAuth()))
		{
			List<SysManagerUserRepertory> repertories = new ArrayList<>();
			String[] repertoryIds = request.getRepertoryAuth().split(",");
			for(int i = 0 ; i < repertoryIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(repertoryIds[i]))
				{
					SysManagerUserRepertory sysManagerUserRepertory = new SysManagerUserRepertory();
					sysManagerUserRepertory.setRepertoryId(Long.valueOf(repertoryIds[i]));
					sysManagerUserRepertory.setManagerId(record.getId());
					repertories.add(sysManagerUserRepertory);
				}
			}
			sysManagerUserRepertoryMapper.insertList(repertories);
		}
		//保存品牌权限
		if(StringUtils.isNotEmpty(request.getBrandAuth()))
		{
			List<SysManagerUserBrand> brands = new ArrayList<>();
			String[] brandIds = request.getBrandAuth().split(",");
			for(int i = 0 ; i < brandIds.length ; i++)
			{
				if(StringUtils.isNotEmpty(brandIds[i]))
				{
					SysManagerUserBrand sysManagerUserBrand = new SysManagerUserBrand();
					sysManagerUserBrand.setBrandId(Long.valueOf(brandIds[i]));
					sysManagerUserBrand.setManagerId(record.getId());
					brands.add(sysManagerUserBrand);
				}
			}
			sysManagerUserBrandMapper.insertList(brands);
		}
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	public UserBaseInfoResp queryUserBaseInfo(UserBaseInfoRequest request)
	{
		UserBaseInfoResp resp = new UserBaseInfoResp();
		try
		{
			SysManagerUserExample example = new SysManagerUserExample();
			com.os.manager.dbmodel.SysManagerUserExample.Criteria criteria = example.createCriteria();
			criteria.andAccountNameEqualTo(request.getAccount());
			if(StringUtils.isNotEmpty(request.getValid()) && request.getValid().equals("1"))
			{
				criteria.andStatusEqualTo(true);
			}
			List<SysManagerUser> users = sysManagerUserMapper.selectByExample(example);
			resp.setAccount(users.get(0).getAccountName());
			resp.setPassword(users.get(0).getPassword());
			resp.setUid(users.get(0).getPassword());
			resp.setUserName(users.get(0).getUserName());
			//查询用户角色
			SysManagerUserRoleExample example2 = new SysManagerUserRoleExample();
			com.os.manager.dbmodel.SysManagerUserRoleExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andManagerIdEqualTo(users.get(0).getId());
			List<SysManagerUserRole> roles = sysManagerUserRoleMapper.selectByExample(example2);
			resp.setRoles(JsonArrayUtils.conver(roles));
			//查询用户角色权限
			List<SysConfigRoleAuth> allRoleAuths = new ArrayList<>();
			roles.forEach(role -> {
				SysConfigRoleAuthExample example3 = new SysConfigRoleAuthExample();
				com.os.manager.dbmodel.SysConfigRoleAuthExample.Criteria criteria3 = example3
					.createCriteria();
				criteria3.andRoleIdEqualTo(role.getRoleId());
				List<SysConfigRoleAuth> roleAuths = sysConfigRoleAuthMapper.selectByExample(example3);
				allRoleAuths.addAll(roleAuths);
			});
			resp.setAuths(JsonArrayUtils.conver(allRoleAuths));
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("用户基本信息查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
