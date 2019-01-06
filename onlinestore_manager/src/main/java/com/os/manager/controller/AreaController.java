
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
import com.os.manager.request.AddAreaRequest;
import com.os.manager.request.DeleteAreaRequest;
import com.os.manager.request.UpdateAreaRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.service.AreaService;

/**
 * 
 * @ClassName: AreaController
 * @Description:TODO(区域配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:22:32
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/config")
public class AreaController
{
	private Logger logger = LogManager.getLogger(AreaController.class);
	@ Autowired
	AreaService    areaService;

	/**
	 * 
	 * @Title: areaConfig @Description: TODO(查询区域配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/areaConfig")
	public TableDataResp areaConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return areaService.queryAreaConfig(request);
	}

	/**
	 * 
	 * @Title: addAreaConfig @Description: TODO(添加区域配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addAreaConfig")
	public BaseResp addAreaConfig(@ Validated @ RequestBody AddAreaRequest request , BindingResult result)
	{
		return areaService.addAreaConfig(request);
	}

	/**
	 * 
	 * @Title: updateAreaConfig @Description: TODO(更新区域配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateAreaConfig")
	public BaseResp updateAreaConfig(@ Validated @ RequestBody UpdateAreaRequest request , BindingResult result)
	{
		return areaService.updateAreaConfig(request);
	}

	/**
	 * 
	 * @Title: deleteAreaConfig @Description: TODO(删除区域配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteAreaConfig")
	public BaseResp deleteAreaConfig(@ Validated @ RequestBody DeleteAreaRequest request , BindingResult result)
	{
		return areaService.deleteAreaConfig(request);
	}
}
