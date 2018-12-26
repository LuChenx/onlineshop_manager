
package com.os.manager.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: RequestParamValidException
 * @Description:TODO(自定义异常，请求接口参数校验失败)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:51:01
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class RequestParamValidException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String		  errorMsg;
}
