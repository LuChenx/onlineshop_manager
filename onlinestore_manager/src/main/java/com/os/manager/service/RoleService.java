
package com.os.manager.service;

import com.os.manager.response.TableDataResp;

/**
 * 
 * @ClassName: RoleService
 * @Description:TODO(岗位相关业务处理)
 * @author: 陆晨曦
 * @date: 2018年12月31日 下午12:32:23
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface RoleService
{
	/**
	 * 
	 * @Title: queryAllRoles @Description:
	 * TODO(查询已有的岗位配置) @param: @return @return: TableDataResp @throws
	 */
	TableDataResp queryAllRoles();
}
