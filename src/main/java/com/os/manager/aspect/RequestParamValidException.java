
package com.os.manager.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * <p>Title: RequestParamValidException.java</p> <p>Description:
 * RequestParamValidException.java</p> <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午2:31:21
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class RequestParamValidException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String		  errorMsg;
}
