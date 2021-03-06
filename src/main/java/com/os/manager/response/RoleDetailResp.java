
package com.os.manager.response;

import java.util.List;

import com.os.manager.response.base.BaseResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: TableDataResp
 * @Description:TODO(基本权限列表返回对象)
 * @author: 陆晨曦
 * @date: 2018年12月30日 下午8:05:57
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class RoleDetailResp extends BaseResp
{
	private long   roleId;
	private String roleName;
	private String roleDesc;
	List<Long>     authIds;
	List<Long>     priceAuthIds;
}
