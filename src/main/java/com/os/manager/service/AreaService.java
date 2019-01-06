
package com.os.manager.service;

import com.os.manager.request.AddAreaRequest;
import com.os.manager.request.DeleteAreaRequest;
import com.os.manager.request.UpdateAreaRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 * @ClassName: AreaService
 * @Description:TODO(区域配置)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午2:26:38
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface AreaService
{
	/**
	 * 
	 * @Title: queryAreaConfig @Description: TODO(查询区域配置) @param: @param
	 *         request @param: @return @return: TableDataResp @throws
	 */
	TableDataResp queryAreaConfig(BaseTableRequest request);

	/**
	 * 
	 * @Title: addAreaConfig @Description: TODO(添加区域配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp addAreaConfig(AddAreaRequest request);

	/**
	 * 
	 * @Title: updateAreaConfig @Description: TODO(更新区域配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp updateAreaConfig(UpdateAreaRequest request);

	/**
	 * 
	 * @Title: deleteAreaConfig @Description: TODO(删除区域配置) @param: @param
	 * request @param: @return @return: BaseResp @throws
	 */
	BaseResp deleteAreaConfig(DeleteAreaRequest request);
}
