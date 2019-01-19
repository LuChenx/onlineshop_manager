
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
import com.os.manager.request.AddSystemOptionRequest;
import com.os.manager.request.DeleteOptionRequest;
import com.os.manager.request.SystemConfigRequest;
import com.os.manager.request.SystemOptionRequest;
import com.os.manager.request.UpdateSystemConfigRequest;
import com.os.manager.request.UpdateSystemOptionRequest;
import com.os.manager.request.base.BaseResq;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.SystemConfigOptionResp;
import com.os.manager.response.SystemOptionTypeResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
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

	/**
	 * 
	 * @Title: addSystemOption @Description: TODO(添加系统选项) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addSystemOption")
	public BaseResp addSystemOption(@ Validated @ RequestBody AddSystemOptionRequest request , BindingResult result)
	{
		return systemConfigService.addSystemOption(request);
	}

	/**
	 * 
	 * @Title: deleteOptionConfig @Description: TODO(删除系统选项) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteOptionConfig")
	public BaseResp deleteOptionConfig(@ Validated @ RequestBody DeleteOptionRequest request , BindingResult result)
	{
		return systemConfigService.deleteOptionConfig(request);
	}

	/**
	 * 
	 * @Title: updateOptionConfig @Description: TODO(更新系统选项) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateOptionConfig")
	public BaseResp updateOptionConfig(@ Validated @ RequestBody UpdateSystemOptionRequest request ,
		BindingResult result)
	{
		return systemConfigService.updateOptionConfig(request);
	}

	/**
	 * 查询系统配置列表
	 * @param request
	 * @param result
	 * @return
	 */
	@ ControllerLogger
	@ RequestMapping ("/systemConfig")
	public TableDataResp systemConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return systemConfigService.systemConfig(request);
	}

	/**
	 * 
	 * @Title: updateSystemConfig @Description: TODO(编辑系统配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateSystemConfig")
	public BaseResp updateSystemConfig(@ Validated @ RequestBody UpdateSystemConfigRequest request ,
		BindingResult result)
	{
		return systemConfigService.updateSystemConfig(request);
	}

	/**
	 * 
	 * @Title: querySystemConfig @Description:
	 *         TODO(查询某类型系统选项) @param: @param request @param: @param
	 *         result @param: @return @return:
	 *         SystemConfigOptionResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/querySystemConfig")
	public SystemConfigOptionResp querySystemConfig(@ Validated @ RequestBody SystemConfigRequest request ,
		BindingResult result)
	{
		return systemConfigService.querySystemConfig(request);
	}
}
