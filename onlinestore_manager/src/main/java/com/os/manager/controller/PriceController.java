
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
import com.os.manager.request.AddPriceRequest;
import com.os.manager.request.DeletePriceRequest;
import com.os.manager.request.UpdatePriceRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.service.PriceService;

/**
 * 
 * @ClassName: PriceController
 * @Description:TODO(价格体系)
 * @author: 陆晨曦
 * @date: 2019年1月5日 下午2:02:08
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/config")
public class PriceController
{
	private Logger logger = LogManager.getLogger(PriceController.class);
	@ Autowired
	PriceService   priceService;

	/**
	 * 
	 * @Title: priceConfig @Description: TODO(查询价格体系配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/priceConfig")
	public TableDataResp priceConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return priceService.queryPiceConfig(request);
	}

	/**
	 * 
	 * @Title: addPriceConfig @Description: TODO(新增价格体系) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addPriceConfig")
	public BaseResp addPriceConfig(@ Validated @ RequestBody AddPriceRequest request , BindingResult result)
	{
		return priceService.addPriceConfig(request);
	}

	/**
	 * 
	 * @Title: updatePriceConfig @Description: TODO(修改价格体系) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updatePriceConfig")
	public BaseResp updatePriceConfig(@ Validated @ RequestBody UpdatePriceRequest request , BindingResult result)
	{
		return priceService.updatePriceConfig(request);
	}

	/**
	 * 
	 * @Title: deletePriceConfig @Description: TODO(删除价格体系配置) @param: @param
	 * request @param: @param result @param: @return @return:
	 * BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deletePriceConfig")
	public BaseResp deletePriceConfig(@ Validated @ RequestBody DeletePriceRequest request , BindingResult result)
	{
		return priceService.deletePriceConfig(request);
	}
}
