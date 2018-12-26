
package com.os.manager.respnse.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求返回通用
 *
 * <p>Title: BaseResp.java</p> <p>Description: BaseResp.java</p> <p>Copyright:
 * Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:53:52
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class BaseResp
{
	//返回码
	String rcode;
	//返回说明
	String rmsg;
}
