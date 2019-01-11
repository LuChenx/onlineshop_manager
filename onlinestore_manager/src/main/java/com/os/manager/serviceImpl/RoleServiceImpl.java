
package com.os.manager.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.os.manager.dao.SysConfigAuthsMapper;
import com.os.manager.dao.SysConfigPriceMapper;
import com.os.manager.dao.SysConfigRoleAuthMapper;
import com.os.manager.dao.SysConfigRolePriceMapper;
import com.os.manager.dao.SysConfigRolesMapper;
import com.os.manager.dbmodel.SysConfigAuths;
import com.os.manager.dbmodel.SysConfigAuthsExample;
import com.os.manager.dbmodel.SysConfigPrice;
import com.os.manager.dbmodel.SysConfigPriceExample;
import com.os.manager.dbmodel.SysConfigRoleAuth;
import com.os.manager.dbmodel.SysConfigRoleAuthExample;
import com.os.manager.dbmodel.SysConfigRoleAuthExample.Criteria;
import com.os.manager.dbmodel.SysConfigRolePrice;
import com.os.manager.dbmodel.SysConfigRolePriceExample;
import com.os.manager.dbmodel.SysConfigRoles;
import com.os.manager.dbmodel.SysConfigRolesExample;
import com.os.manager.model.Node;
import com.os.manager.request.AddRoleRequest;
import com.os.manager.request.DeleteRoleRequest;
import com.os.manager.request.RoleDetailRequest;
import com.os.manager.request.UpdateRoleAuthRequest;
import com.os.manager.request.UpdateRoleRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.BaseAuthResp;
import com.os.manager.response.RoleDetailResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.RoleService;
import com.os.manager.utils.JsonArrayUtils;

/**
 * 
 * @ClassName: RoleServiceImpl
 * @Description:TODO(岗位相关业务处理实现)
 * @author: 陆晨曦
 * @date: 2018年12月31日 下午12:34:02
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Service ("roleService")
public class RoleServiceImpl implements RoleService
{
	private Logger		 logger	= LogManager.getLogger(RoleServiceImpl.class);
	@ Autowired
	SysConfigRolesMapper	 sysConfigRolesMapper;
	@ Autowired
	SysConfigAuthsMapper	 sysConfigAuthsMapper;
	@ Autowired
	SysConfigPriceMapper	 sysConfigPriceMapper;
	@ Autowired
	SysConfigRoleAuthMapper	 sysConfigRoleAuthMapper;
	@ Autowired
	SysConfigRolePriceMapper sysConfigRolePriceMapper;

	/**
	 * 
	 * <p>Title: queryAllRoles</p> <p>Description: 查询已有的岗位</p>
	 * @return
	 * @see com.os.manager.service.RoleService#queryAllRoles()
	 */
	@ Override
	public TableDataResp queryAllRoles(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysConfigRolesExample example = new SysConfigRolesExample();
			example.setOrderByClause("role_name " + request.getSortOrder());
			List<SysConfigRoles> roles = sysConfigRolesMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(roles))
			{
				resp.setRows(JsonArrayUtils.conver(roles));
				resp.setTotal(sysConfigRolesMapper.countByExample(new SysConfigRolesExample()));
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseAuthResp queryAuthConfig()
	{
		BaseAuthResp resp = new BaseAuthResp();
		try
		{
			List<SysConfigAuths> auths = sysConfigAuthsMapper.selectByExample(new SysConfigAuthsExample());
			if(CollectionUtils.isNotEmpty(auths))
			{
				List<Node> nodes = new ArrayList<>();
				auths.forEach(e -> {
					Node node = new Node();
					node.setText(e.getAuthName());
					node.setNodeId(e.getId());
					nodes.add(node);
				});
				resp.setNodes(JsonArrayUtils.conver(nodes));
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位权限配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseAuthResp queryPriceAuthConfig()
	{
		BaseAuthResp resp = new BaseAuthResp();
		try
		{
			List<SysConfigPrice> prices = sysConfigPriceMapper.selectByExample(new SysConfigPriceExample());
			if(CollectionUtils.isNotEmpty(prices))
			{
				List<Node> nodes = new ArrayList<>();
				prices.forEach(e -> {
					Node node = new Node();
					node.setText(e.getPriceName());
					node.setNodeId(e.getId());
					nodes.add(node);
				});
				resp.setNodes(JsonArrayUtils.conver(nodes));
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("价格权限配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp addRoleConfig(AddRoleRequest request)
	{
		BaseResp resp = new BaseResp();
		//保存岗位基本信息
		SysConfigRoles record = new SysConfigRoles();
		record.setRoleDesc(request.getRoleDesc());
		record.setRoleName(request.getRoleName());
		sysConfigRolesMapper.insertSelective(record);
		//保存岗位权限
		String auth = request.getAuth();
		String[] authArr = auth.split(",");
		List<SysConfigRoleAuth> configs = new ArrayList<>();
		for(int i = 0 ; i < authArr.length ; i++)
		{
			SysConfigRoleAuth config = new SysConfigRoleAuth();
			config.setAuthId(Long.valueOf(authArr[i]));
			config.setRoleId(record.getId());
			configs.add(config);
		}
		sysConfigRoleAuthMapper.insertList(configs);
		//保存价格权限
		String priceAuth = request.getPriceAuth();
		String[] priceAuthArr = priceAuth.split(",");
		List<SysConfigRolePrice> priceConfigs = new ArrayList<>();
		for(int i = 0 ; i < priceAuthArr.length ; i++)
		{
			SysConfigRolePrice config = new SysConfigRolePrice();
			config.setPriceId(Long.valueOf(priceAuthArr[i]));
			config.setRoleId(record.getId());
			priceConfigs.add(config);
		}
		sysConfigRolePriceMapper.insertList(priceConfigs);
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp deleteRoleConfig(DeleteRoleRequest request)
	{
		BaseResp resp = new BaseResp();
		//删除角色基本配置信息
		sysConfigRolesMapper.deleteByPrimaryKey(request.getRoleId());
		//删除岗位权限配置信息
		SysConfigRoleAuthExample example = new SysConfigRoleAuthExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(request.getRoleId());
		sysConfigRoleAuthMapper.deleteByExample(example);
		//删除岗位价格权限配置信息
		SysConfigRolePriceExample example2 = new SysConfigRolePriceExample();
		com.os.manager.dbmodel.SysConfigRolePriceExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andRoleIdEqualTo(request.getRoleId());
		sysConfigRolePriceMapper.deleteByExample(example2);
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	public RoleDetailResp queryRoleDetail(RoleDetailRequest request)
	{
		RoleDetailResp resp = new RoleDetailResp();
		try
		{
			//基本信息
			SysConfigRoles baseConfig = sysConfigRolesMapper.selectByPrimaryKey(request.getRoleId());
			resp.setRoleId(request.getRoleId());
			resp.setRoleName(baseConfig.getRoleName());
			resp.setRoleDesc(baseConfig.getRoleDesc());
			//岗位权限信息
			SysConfigRoleAuthExample example = new SysConfigRoleAuthExample();
			Criteria criteria = example.createCriteria();
			criteria.andRoleIdEqualTo(request.getRoleId());
			List<SysConfigRoleAuth> auths = sysConfigRoleAuthMapper.selectByExample(example);
			List<Long> authIds = new ArrayList<>();
			auths.forEach(auth -> {
				authIds.add(auth.getAuthId());
			});
			resp.setAuthIds(authIds);
			//岗位价格权限信息
			SysConfigRolePriceExample example2 = new SysConfigRolePriceExample();
			com.os.manager.dbmodel.SysConfigRolePriceExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andRoleIdEqualTo(request.getRoleId());
			List<SysConfigRolePrice> prices = sysConfigRolePriceMapper.selectByExample(example2);
			List<Long> priceAuthIds = new ArrayList<>();
			prices.forEach(auth -> {
				priceAuthIds.add(auth.getPriceId());
			});
			resp.setPriceAuthIds(priceAuthIds);
			resp.setRoleId(request.getRoleId());
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	@ Transactional
	public BaseResp updateRoleConfig(UpdateRoleRequest request)
	{
		BaseResp resp = new BaseResp();
		//修改基本信息
		SysConfigRoles record = new SysConfigRoles();
		record.setId(request.getRoleId());
		record.setRoleDesc(request.getRoleDesc());
		record.setRoleName(request.getRoleName());
		sysConfigRolesMapper.updateByPrimaryKey(record);
		//修改岗位权限信息
		//删除岗位权限配置信息
		SysConfigRoleAuthExample example = new SysConfigRoleAuthExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(request.getRoleId());
		sysConfigRoleAuthMapper.deleteByExample(example);
		//添加新配置信息
		String auth = request.getAuth();
		String[] authArr = auth.split(",");
		List<SysConfigRoleAuth> configs = new ArrayList<>();
		for(int i = 0 ; i < authArr.length ; i++)
		{
			SysConfigRoleAuth config = new SysConfigRoleAuth();
			config.setAuthId(Long.valueOf(authArr[i]));
			config.setRoleId(record.getId());
			configs.add(config);
		}
		sysConfigRoleAuthMapper.insertList(configs);
		//修改价格权限信息
		//删除岗位价格权限配置信息
		SysConfigRolePriceExample example2 = new SysConfigRolePriceExample();
		com.os.manager.dbmodel.SysConfigRolePriceExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andRoleIdEqualTo(request.getRoleId());
		sysConfigRolePriceMapper.deleteByExample(example2);
		//添加新配置价格权限信息
		String priceAuth = request.getPriceAuth();
		String[] priceAuthArr = priceAuth.split(",");
		List<SysConfigRolePrice> priceConfigs = new ArrayList<>();
		for(int i = 0 ; i < priceAuthArr.length ; i++)
		{
			SysConfigRolePrice config = new SysConfigRolePrice();
			config.setPriceId(Long.valueOf(priceAuthArr[i]));
			config.setRoleId(record.getId());
			priceConfigs.add(config);
		}
		sysConfigRolePriceMapper.insertList(priceConfigs);
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		return resp;
	}

	@ Override
	public TableDataResp queryRoleAuthConfig(BaseTableRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			//查询所有角色的权限配置
			List<SysConfigRoleAuth> roleAuths = sysConfigRoleAuthMapper
				.selectByExample(new SysConfigRoleAuthExample());
			//查询所有权限
			SysConfigAuthsExample example = new SysConfigAuthsExample();
			example.setOrderByClause("auth_name " + request.getSortOrder());
			List<SysConfigAuths> auths = sysConfigAuthsMapper.selectByExample(example);
			resp.setTotal(auths.size());
			JSONArray datas = new JSONArray();
			auths.forEach(auth -> {
				JSONObject row = new JSONObject();
				row.put("authName", auth.getAuthName());
				row.put("authDesc", auth.getAuthDesc());
				row.put("authId", auth.getId());
				roleAuths.forEach(ra -> {
					if(auth.getId() == ra.getAuthId())
					{
						row.put(String.valueOf(ra.getRoleId()), true);
					}
				});
				datas.add(row);
			});
			resp.setRows(datas);
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位权限配置查询失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	@ Override
	public BaseResp updateRoleAuth(UpdateRoleAuthRequest request)
	{
		BaseResp resp = new BaseResp();
		try
		{
			if(request.isType())
			{
				//添加
				SysConfigRoleAuth record = new SysConfigRoleAuth();
				record.setRoleId(request.getRoleId());
				record.setAuthId(request.getAuthId());
				sysConfigRoleAuthMapper.insert(record);
			}
			else
			{
				//删除
				SysConfigRoleAuthExample example = new SysConfigRoleAuthExample();
				Criteria criteria = example.createCriteria();
				criteria.andAuthIdEqualTo(request.getAuthId());
				criteria.andRoleIdEqualTo(request.getRoleId());
				sysConfigRoleAuthMapper.deleteByExample(example);
			}
			resp.setRcode(ReturnCode.CODE_000000);
			resp.setRmsg(ReturnCode.INFO_000000);
		}
		catch (Exception e)
		{
			logger.error("岗位配置调整失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}
}
