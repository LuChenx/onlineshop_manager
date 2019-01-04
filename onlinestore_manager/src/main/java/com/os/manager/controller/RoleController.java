
package com.os.manager.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.manager.aspect.ControllerLogger;
import com.os.manager.request.AddRoleRequest;
import com.os.manager.request.DeleteRoleRequest;
import com.os.manager.request.RoleDetailRequest;
import com.os.manager.request.UpdateRoleRequest;
import com.os.manager.request.base.BaseResq;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.BaseAuthResp;
import com.os.manager.response.RoleDetailResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
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
	private Logger logger = LogManager.getLogger(RoleController.class);
	@ Autowired
	RoleService    roleService;

	/**
	 * 
	 * @Title: roleConfig @Description: TODO(查询已有的岗位配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/conifg")
	public TableDataResp roleConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return roleService.queryAllRoles(request);
	}

	/**
	 * 
	 * @Title: authConfig @Description: TODO(查询已有的岗位权限配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseAuthResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/authConfig")
	public BaseAuthResp authConfig(@ Validated @ RequestBody BaseResq request , BindingResult result)
	{
		return roleService.queryAuthConfig();
	}

	/**
	 * 
	 * @Title: priceAuthConfig @Description:
	 *         TODO(查询已有的岗位权限配置) @param: @param request @param: @param
	 *         result @param: @return @return: BaseAuthResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/priceAuthConfig")
	public BaseAuthResp priceAuthConfig(@ Validated @ RequestBody BaseResq request , BindingResult result)
	{
		return roleService.queryPriceAuthConfig();
	}

	/**
	 * 
	 * @Title: addconifg @Description: TODO(添加岗位配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addconfig")
	public BaseResp addconifg(@ Validated @ RequestBody AddRoleRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = roleService.addRoleConfig(request);
		}
		catch (Exception e)
		{
			logger.error("岗位配置添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: updateConfig @Description: TODO(修改岗位配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateConfig")
	public BaseResp updateConfig(@ Validated @ RequestBody UpdateRoleRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = roleService.updateRoleConfig(request);
		}
		catch (Exception e)
		{
			logger.error("岗位配置修改失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: addconifg @Description: TODO(删除岗位配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteConfig")
	public BaseResp deleteConfig(@ Validated @ RequestBody DeleteRoleRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = roleService.deleteRoleConfig(request);
		}
		catch (Exception e)
		{
			logger.error("岗位配置删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: configDetail @Description: TODO(岗位详情查询) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         RoleDetailResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/configDetail")
	public RoleDetailResp configDetail(@ Validated @ RequestBody RoleDetailRequest request , BindingResult result)
	{
		return roleService.queryRoleDetail(request);
	}

	/**
	 * 
	 * @Title: roleAuthConfig @Description: TODO(查询已有的岗位权限配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/roleAuthConfig")
	public TableDataResp roleAuthConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return roleService.queryRoleAuthConfig(request);
	}
}
