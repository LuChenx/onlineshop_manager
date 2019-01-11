
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UpdateSystemConfigRequest
 * @Description:TODO(更新系统配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:43:04
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class UpdateSystemConfigRequest extends BaseResq
{
	long   configId;
	String configValue;
}
