
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
import com.os.manager.request.AddSupplierUserRequest;
import com.os.manager.request.DeleteSupplierRequest;
import com.os.manager.request.DeleteSupplierUserRequest;
import com.os.manager.request.SupplierUserRequest;
import com.os.manager.request.UpdateSupplierRequest;
import com.os.manager.request.UpdateSupplierUserRequest;
import com.os.manager.request.UploadExcelRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;
import com.os.manager.service.SupplierService;
import com.os.manager.service.UserService;

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
	@ Autowired
	UserService	userService;

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

	/**
	 * 
	 * @Title: supplierUserList @Description: TODO(供货商联系人列表) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         TableDataResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/supplierUserList")
	public TableDataResp supplierUserList(@ Validated @ RequestBody SupplierUserRequest request ,
		BindingResult result)
	{
		return userService.querySupplierUserList(request);
	}

	/**
	 * 
	 * @Title: addSupplierUser @Description: TODO(添加供货商联系人) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/addSupplierUser")
	public BaseResp addSupplierUser(@ Validated @ RequestBody AddSupplierUserRequest request , BindingResult result)
	{
		return userService.addSupplierUser(request);
	}

	/**
	 * 
	 * @Title: deleteSupplierUser @Description:
	 *         TODO(删除供货商联系人) @param: @param request @param: @param
	 *         result @param: @return @return: BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteSupplierUser")
	public BaseResp deleteSupplierUser(@ Validated @ RequestBody DeleteSupplierUserRequest request ,
		BindingResult result)
	{
		return userService.deleteSupplierUser(request);
	}

	/**
	 * 
	 * @Title: deleteSupplier @Description: TODO(删除供货商) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/deleteSupplier")
	public BaseResp deleteSupplier(@ Validated @ RequestBody DeleteSupplierRequest request , BindingResult result)
	{
		BaseResp resp = new BaseResp();
		try
		{
			resp = supplierService.deleteSupplier(request);
		}
		catch (Exception e)
		{
			logger.error("供货商删除失败！", e);
			resp.setRcode(ReturnCode.CODE_199999);
			resp.setRmsg(ReturnCode.INFO_199999);
		}
		return resp;
	}

	/**
	 * 
	 * @Title: updateSupplier @Description: TODO(更新供货单位信息) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResq @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateSupplier")
	public BaseResp updateSupplier(@ Validated @ RequestBody UpdateSupplierRequest request , BindingResult result)
	{
		return supplierService.updateSupplier(request);
	}

	/**
	 * 
	 * @Title: updateSupplierUser @Description:
	 *         TODO(更新供货商联系人) @param: @param request @param: @param
	 *         result @param: @return @return: BaseResp @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/updateSupplierUser")
	public BaseResp updateSupplierUser(@ Validated @ RequestBody UpdateSupplierUserRequest request ,
		BindingResult result)
	{
		return userService.updateSupplierUser(request);
	}

	/**
	 * 
	 * @Title: uploadSupplier @Description: TODO(上传供货商Excel) @param: @param
	 *         request @param: @param result @param: @return @return:
	 *         BaseResq @throws
	 */
	@ ControllerLogger
	@ RequestMapping ("/uploadSupplier")
	public BaseResp uploadSupplier(@ Validated @ RequestBody UploadExcelRequest request , BindingResult result)
	{
		return supplierService.uploadSupplier(request);
	}
}
