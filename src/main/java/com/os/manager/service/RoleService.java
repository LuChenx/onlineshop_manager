
package com.os.manager.service;

import com.os.manager.request.AddRoleRequest;
import com.os.manager.request.DeleteRoleRequest;
import com.os.manager.request.RoleDetailRequest;
import com.os.manager.request.UpdateRoleAuthRequest;
import com.os.manager.request.UpdateRoleRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.BaseAuthResp;
import com.os.manager.response.RoleDetailResp;
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
	TableDataResp queryAllRoles(BaseTableRequest request);

	/**
	 * 
	 * @Title: queryAllRoles @Description:
	 *         TODO(查询已有的岗位权限配置) @param: @return @return:
	 *         TableDataResp @throws
	 */
	TableDataResp queryRoleAuthConfig(BaseTableRequest request);

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
	 * @Title: addRoleConfig @Description:
	 *         TODO(添加岗位配置) @param: @return @return: BaseAuthResp @throws
	 */
	BaseResp addRoleConfig(AddRoleRequest request);

	/**
	 * 
	 * @Title: updateRoleConfig @Description:
	 *         TODO(修改岗位配置) @param: @return @return: BaseAuthResp @throws
	 */
	BaseResp updateRoleConfig(UpdateRoleRequest request);

	/**
	 * 
	 * @Title: deleteRoleConfig @Description:
	 *         TODO(删除岗位配置) @param: @return @return: BaseAuthResp @throws
	 */
	BaseResp deleteRoleConfig(DeleteRoleRequest request);

	/**
	 * 
	 * @Title: queryRoleDetail @Description:
	 *         TODO(岗位详情) @param: @return @return: BaseAuthResp @throws
	 */
	RoleDetailResp queryRoleDetail(RoleDetailRequest request);

	/**
	 * 更新角色权限
	 * @param request
	 * @return
	 */
	BaseResp updateRoleAuth(UpdateRoleAuthRequest request);
}
