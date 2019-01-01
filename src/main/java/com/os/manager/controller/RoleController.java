
package com.os.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.manager.aspect.ControllerLogger;
import com.os.manager.request.base.BaseResq;
import com.os.manager.response.TableDataResp;
import com.os.manager.service.RoleService;

/**
 * 
 * @ClassName: RoleController
 * @Description:TODO(岗位操作相关增删改查)
 * @author: 陆晨曦
 * @date: 2018年12月30日 下午7:47:26
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/role")
public class RoleController
{
	@ Autowired
	RoleService roleService;

	/**
	 * 
	 * @Title: roleConfig @Description: TODO(查询已有的岗位配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/conifg")
	public TableDataResp roleConfig(@ Validated @ RequestBody BaseResq request , BindingResult result)
	{
		return roleService.queryAllRoles();
	}
}
