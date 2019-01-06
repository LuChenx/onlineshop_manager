
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
import com.os.manager.request.AddBrandRequest;
import com.os.manager.request.DeleteBrandRequest;
import com.os.manager.request.UpdateBrandRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.service.BrandService;

/**
 * 
 * @ClassName: BrandController
 * @Description:TODO(商品管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午5:58:31
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/config")
public class BrandController
{
	private Logger logger = LogManager.getLogger(BrandController.class);
	@ Autowired
	BrandService   brandService;

	/**
	 * 
	 * @Title: brandConfig @Description: TODO(查询区域配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/brandConfig")
	public TableDataResp brandConfig(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return brandService.queryBrandConfig(request);
	}

	/**
	 * 
	 * @Title: addBrandConfig @Description: TODO(添加物品配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addBrandConfig")
	public BaseResp addBrandConfig(@ Validated @ RequestBody AddBrandRequest request , BindingResult result)
	{
		return brandService.addBrandConfig(request);
	}

	/**
	 * 
	 * @Title: updateBrandConfig @Description: TODO(更新商品配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateBrandConfig")
	public BaseResp updateBrandConfig(@ Validated @ RequestBody UpdateBrandRequest request , BindingResult result)
	{
		return brandService.updateBrandConfig(request);
	}

	/**
	 * 
	 * @Title: deleteBrandConfig @Description: TODO(删除商品配置) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteBrandConfig")
	public BaseResp deleteBrandConfig(@ Validated @ RequestBody DeleteBrandRequest request , BindingResult result)
	{
		return brandService.deleteBrandConfig(request);
	}
}
