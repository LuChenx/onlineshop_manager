
package com.os.manager.request.base;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: BaseResq
 * @Description:TODO(请求通用参数)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:42:42
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ AllArgsConstructor
@ NoArgsConstructor
public class BaseResq
{
	//请求发起者
	@ NotBlank (message = "请先登录！")
	String uid;
	//请求客户端
	@ NotBlank (message = "无效请求来源！")
	@ Pattern (regexp = "^1|2$" ,message = "无效请求来源！")
	String appId;
}
