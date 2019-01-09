
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
import com.os.manager.request.SystemOptionRequest;
import com.os.manager.request.base.BaseResq;
import com.os.manager.response.SystemOptionTypeResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.service.SystemConfigService;

/**
 * 
 * @ClassName: SystemController
 * @Description:TODO(系统配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:22:32
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/config")
public class SystemController
{
	private Logger	    logger = LogManager.getLogger(SystemController.class);
	@ Autowired
	SystemConfigService systemConfigService;

	/**
	 * 
	 * @Title: optionTypeList @Description: TODO(查询系统选项类型) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         SystemOptionTypeResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/optionTypeList")
	public SystemOptionTypeResp optionTypeList(@ Validated @ RequestBody BaseResq request , BindingResult result)
	{
		return systemConfigService.queryOptionTypeList(request);
	}

	/**
	 * 查询系统配置
	 * @param request
	 * @param result
	 * @return
	 */
	@ ControllerLogger
	@ RequestMapping ("/options")
	public TableDataResp options(@ Validated @ RequestBody SystemOptionRequest request , BindingResult result)
	{
		return systemConfigService.querySystemOptions(request);
	}
}
