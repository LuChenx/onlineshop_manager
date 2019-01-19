
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UpdateSupplierRequest
 * @Description:TODO(更新供货单位)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:42:42
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ AllArgsConstructor
@ NoArgsConstructor
public class UpdateSupplierRequest extends BaseResq
{
	long	companyId;
	String	companyName;
	String	companyAddress;
	String	zipCode;
	String	phone;
	String	companyFax;
	String	duty;
	String	bank;
	String	account;
	String	website;
	String	email;
	String	note;
	boolean	rebate;
}
