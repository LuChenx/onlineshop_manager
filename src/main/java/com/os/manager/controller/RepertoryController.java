
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
import com.os.manager.request.AddRepertoryRequest;
import com.os.manager.request.DeleteRepertoryRequest;
import com.os.manager.request.UpdateRepertoryRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.service.RepertoryService;

/**
 * 
 * @ClassName: RepertoryController
 * @Description:TODO(仓库管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午3:10:44
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/config")
public class RepertoryController
{
	private Logger	 logger	= LogManager.getLogger(RepertoryController.class);
	@ Autowired
	RepertoryService repertoryService;

	/**
	 * 
	 * @Title: repertoryConfig @Description: TODO(查询仓库配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/repertoryConfig")
	public TableDataResp repertoryConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return repertoryService.queryRepertoryConfig(request);
	}

	/**
	 * 
	 * @Title: addRepertoryConfig @Description: TODO(添加仓库配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addRepertoryConfig")
	public BaseResp addRepertoryConfig(@ Validated @ RequestBody AddRepertoryRequest request , BindingResult result)
	{
		return repertoryService.addRepertoryConfig(request);
	}

	/**
	 * 
	 * @Title: updateRepertoryConfig @Description:
	 *         TODO(更新仓库信息) @param: @param request @param: @param
	 *         result @param: @return @return: BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateRepertoryConfig")
	public BaseResp updateRepertoryConfig(@ Validated @ RequestBody UpdateRepertoryRequest request ,
		BindingResult result)
	{
		return repertoryService.updateRepertoryConfig(request);
	}

	/**
	 * 
	 * @Title: deleteRepertoryConfig @Description:
	 * TODO(删除仓库配置) @param: @param request @param: @param
	 * result @param: @return @return: BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteRepertoryConfig")
	public BaseResp deleteRepertoryConfig(@ Validated @ RequestBody DeleteRepertoryRequest request ,
		BindingResult result)
	{
		return repertoryService.deleteRepertoryConfig(request);
	}
}
