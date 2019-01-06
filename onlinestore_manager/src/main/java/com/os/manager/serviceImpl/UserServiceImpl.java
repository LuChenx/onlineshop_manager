
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysManagerUserMapper;
import com.os.manager.dbmodel.SysManagerUser;
import com.os.manager.dbmodel.SysManagerUserExample;
import com.os.manager.dbmodel.SysManagerUserExample.Criteria;
import com.os.manager.request.UserListRequest;
import com.os.manager.response.TableDataResp;
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
	private Logger	     logger = LogManager.getLogger(UserServiceImpl.class);
	@ Autowired
	SysManagerUserMapper sysManagerUserMapper;

	@ Override
	public TableDataResp queryUserList(UserListRequest request)
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			SysManagerUserExample example = new SysManagerUserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameLike(request.getSearchInfo());
			Criteria criteria1 = example.createCriteria();
			criteria1.andAccountNameLike(request.getSearchInfo());
			example.or(criteria1);
			Criteria criteria2 = example.createCriteria();
			criteria2.andUserPhoneLike(request.getSearchInfo());
			example.or(criteria2);
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
}
