
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * <p>Title: AddUserRequest.java</p> <p>Description: AddUserRequest.java</p>
 * <p>Copyright: Copyright (c) 2019</p> <p>Company: luchenxi </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2019年1月8日 上午9:02:10
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class AddUserRequest extends BaseResq
{
	String	account;
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
