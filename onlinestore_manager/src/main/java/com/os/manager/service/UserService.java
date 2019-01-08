
package com.os.manager.service;

import com.os.manager.request.AddUserRequest;
import com.os.manager.request.DeleteUserRequest;
import com.os.manager.request.UpdateUserRequest;
import com.os.manager.request.UserAuthRequest;
import com.os.manager.request.UserListRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.UserAuthListResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 * @ClassName: UserService
 * @Description:TODO(操作员管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午7:54:26
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface UserService
{
	/**
	 * 
	 * @Title: queryUserList @Description: TODO(查询用户列表) @param: @param
	 *         request @param: @return @return: TableDataResp @throws
	 */
	TableDataResp queryUserList(UserListRequest request);

	/**
	 * 
	 * @Title: addUser @Description: TODO(添加用户) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp addUser(AddUserRequest request);

	/**
	 * 
	 * @Title: deleteUser @Description: TODO(删除用户) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp deleteUser(DeleteUserRequest request);

	/**
	 * 
	 * @Title: queryUserAuthList @Description: TODO(用户权限列表) @param: @param
	 *         request @param: @return @return: UserAuthListResp @throws
	 */
	UserAuthListResp queryUserAuthList(UserAuthRequest request);

	/**
	 * 
	 * @Title: updateUser @Description: TODO(更新用户) @param: @param
	 * request @param: @return @return: BaseResp @throws
	 */
	BaseResp updateUser(UpdateUserRequest request);
}
