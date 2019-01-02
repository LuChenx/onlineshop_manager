
package com.os.manager.serviceImpl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.manager.dao.SysConfigRolesMapper;
import com.os.manager.dbmodel.SysConfigRoles;
import com.os.manager.dbmodel.SysConfigRolesExample;
import com.os.manager.response.TableDataResp;
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
	private Logger	     logger = LogManager.getLogger(RoleServiceImpl.class);
	@ Autowired
	SysConfigRolesMapper sysConfigRolesMapper;

	/**
	 * 
	 * <p>Title: queryAllRoles</p> <p>Description: 查询已有的岗位</p>
	 * @return
	 * @see com.os.manager.service.RoleService#queryAllRoles()
	 */
	@ Override
	public TableDataResp queryAllRoles()
	{
		TableDataResp resp = new TableDataResp();
		try
		{
			List<SysConfigRoles> roles = sysConfigRolesMapper.selectByExample(new SysConfigRolesExample());
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
}
