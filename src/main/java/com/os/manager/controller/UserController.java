
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
import com.os.manager.request.AddUserRequest;
import com.os.manager.request.DeleteUserRequest;
import com.os.manager.request.UserAuthRequest;
import com.os.manager.request.UserListRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.UserAuthListResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.UserService;

/**
 * 
 * @ClassName: UserController
 * @Description:TODO(操作员管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午7:52:54
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/user")
public class UserController
{
	private Logger logger = LogManager.getLogger(UserController.class);
	@ Autowired
	UserService    userService;

	/**
	 * 
	 * @Title: list @Description: TODO(管理员列表) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/list")
	public TableDataResp list(@ Validated @ RequestBody UserListRequest request , BindingResult result)
	{
		return userService.queryUserList(request);
	}

	/**
	 * 
	 * @Title: addUser @Description: TODO(添加操作员) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addUser")
	public BaseResp addUser(@ Validated @ RequestBody AddUserRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = userService.addUser(request);
		}
		catch (Exception e)
		{
			logger.error("操作员添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: deleteUser @Description: TODO(删除操作员) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteUser")
	public BaseResp deleteUser(@ Validated @ RequestBody DeleteUserRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = userService.deleteUser(request);
		}
		catch (Exception e)
		{
			logger.error("操作员添加失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: authList @Description: TODO(删除操作员) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         UserAuthListResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/authList")
	public UserAuthListResp authList(@ Validated @ RequestBody UserAuthRequest request , BindingResult result)
	{
		return userService.queryUserAuthList(request);
	}
}
