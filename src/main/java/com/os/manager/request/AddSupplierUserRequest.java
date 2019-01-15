
package com.os.manager.request;

import java.util.Date;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: AddSupplierUserRequest
 * @Description:TODO(请求添加供货商联系人)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:42:42
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ AllArgsConstructor
@ NoArgsConstructor
public class AddSupplierUserRequest extends BaseResq
{
	String userName;
	int    userSex;
	Date   birthday;
	long   companyId;
	String apartment;
	String role;
	String userphone;
	String userfax;
	String mobile;
	String wechat;
	String useremail;
	String exprice;
	String hobby;
	String note;
}
