
package com.os.manager.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UserBaseInfoRequest
 * @Description:TODO(用户基本信息)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:33:52
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class UserBaseInfoRequest
{
	//请求客户端
	@ NotBlank (message = "无效请求来源！")
	@ Pattern (regexp = "^1|2$" ,message = "无效请求来源！")
	String appId;
	//请求秘钥
	@ NotBlank (message = "非法请求！")
	@ Pattern (regexp = "^password@123$" ,message = "非法请求！")
	String appKey;
	String valid;
	String account;
}
