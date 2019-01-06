
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: DeleteAreaRequest
 * @Description:TODO(删除仓库配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:48:52
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ AllArgsConstructor
@ NoArgsConstructor
public class DeleteRepertoryRequest extends BaseResq
{
	long repertoryId;
}
