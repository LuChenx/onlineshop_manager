
package com.os.manager.service;

import com.os.manager.request.AddRepertoryRequest;
import com.os.manager.request.DeleteRepertoryRequest;
import com.os.manager.request.UpdateRepertoryRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 * @ClassName: RepertoryService
 * @Description:TODO(仓库配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午3:14:55
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface RepertoryService
{
	/**
	 * 
	 * @Title: queryRepertoryConfig @Description:
	 *         TODO(查询仓库配置) @param: @param request @param: @return @return:
	 *         TableDataResp @throws
	 */
	TableDataResp queryRepertoryConfig(BaseTableRequest request);

	/**
	 * 
	 * @Title: addRepertoryConfig @Description: TODO(添加仓库配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp addRepertoryConfig(AddRepertoryRequest request);

	/**
	 * 
	 * @Title: updateRepertoryConfig @Description:
	 *         TODO(修改仓库信息) @param: @param request @param: @return @return:
	 *         BaseResp @throws
	 */
	BaseResp updateRepertoryConfig(UpdateRepertoryRequest request);

	/**
	 * 
	 * @Title: deleteRepertoryConfig @Description:
	 *         TODO(删除仓库信息) @param: @param request @param: @return @return:
	 *         BaseResp @throws
	 */
	BaseResp deleteRepertoryConfig(DeleteRepertoryRequest request);
}
