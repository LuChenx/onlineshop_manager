
package com.os.manager.response;

import com.os.manager.respnse.base.BaseResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 测试用
 *
 * <p>Title: TestResp.java</p> <p>Description: TestResp.java</p> <p>Copyright:
 * Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:51:34
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
@ ToString (callSuper = true)
public class TestResp extends BaseResp
{
	String systemName;
	String varsion;
}
