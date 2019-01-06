
package com.os.manager.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: UpdateAreaRequest
 * @Description:TODO(更新区域)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:43:04
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class UpdateAreaRequest
{
	long   areaId;
	String areaName;
	int    areaIndex;
}
