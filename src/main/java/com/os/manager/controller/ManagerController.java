
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
import com.os.manager.request.AddSupplierRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.service.SupplierService;

/**
 * 
 * @ClassName: ManagerController
 * @Description:TODO(管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:22:32
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ RestController
@ RequestMapping (value = "/system/manager")
public class ManagerController
{
	private Logger	logger = LogManager.getLogger(ManagerController.class);
	@ Autowired
	SupplierService	supplierService;

	/**
	 * 
	 * @Title: addSupplier @Description: TODO(添加供货单位信息) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResq @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addSupplier")
	public BaseResp addSupplier(@ Validated @ RequestBody AddSupplierRequest request , BindingResult result)
	{
		return supplierService.addSupplier(request);
	}

	/**
	 * 
	 * @Title: supplierList @Description: TODO(供货单位列表) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/supplierList")
	public TableDataResp supplierList(@ Validated @ RequestBody BaseTableRequest request , BindingResult result)
	{
		return supplierService.supplierList(request);
	}
}
