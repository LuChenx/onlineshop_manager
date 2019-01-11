
package com.os.manager.service;

import com.os.manager.request.AddSupplierRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 *
 * <p>Title: SupplierService.java</p> <p>Description: SupplierService.java</p>
 * <p>Copyright: Copyright (c) 2019</p> <p>Company: FPI </p>
 * @author 18163
 * @version 1.0
 * @creattime 2019年1月11日 下午3:38:53
 */
public interface SupplierService
{
	/**
	 * 添加供货商基本信息
	 * @param request
	 * @return
	 */
	BaseResp addSupplier(AddSupplierRequest request);

	/**
	 * 供货商列表
	 * @param request
	 * @return
	 */
	TableDataResp supplierList(BaseTableRequest request);
}
