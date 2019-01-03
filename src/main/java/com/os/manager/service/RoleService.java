
package com.os.manager.service;

import com.os.manager.request.AddRoleRequest;
import com.os.manager.request.DeleteRoleRequest;
import com.os.manager.response.BaseAuthResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

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
	 *         TODO(查询已有的岗位配置) @param: @return @return:
	 *         TableDataResp @throws
	 */
	TableDataResp queryAllRoles();

	/**
	 * 
	 * @Title: queryAuthConfig @Description:
	 *         TODO(查询已有的岗位权限配置) @param: @return @return:
	 *         BaseAuthResp @throws
	 */
	BaseAuthResp queryAuthConfig();

	/**
	 * 
	 * @Title: queryPriceAuthConfig @Description:
	 *         TODO(查询已有的借个权限配置) @param: @return @return:
	 *         BaseAuthResp @throws
	 */
	BaseAuthResp queryPriceAuthConfig();

	/**
	 * 
	 * @Title: queryPriceAuthConfig @Description:
	 *         TODO(添加岗位配置) @param: @return @return: BaseAuthResp @throws
	 */
	BaseResp addRoleConfig(AddRoleRequest request);

	/**
	 * 
	 * @Title: queryPriceAuthConfig @Description:
	 *         TODO(删除岗位配置) @param: @return @return: BaseAuthResp @throws
	 */
	BaseResp deleteRoleConfig(DeleteRoleRequest request);
}
