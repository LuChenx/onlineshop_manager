
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UpdateUserRequest
 * @Description:TODO(更新用户)
 * @author: 陆晨曦
 * @date: 2019年1月8日 下午8:23:16
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class UpdateUserRequest extends BaseResq
{
	String	account;
	String	userId;
	String	password;
	String	userName;
	String	userPhone;
	Boolean	status;
	String	auth;
	Boolean	areaStatus;
	String	areaAuth;
	Boolean	repertoryStatus;
	String	repertoryAuth;
	Boolean	brandStatus;
	String	brandAuth;
}
