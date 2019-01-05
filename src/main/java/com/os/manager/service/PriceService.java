
package com.os.manager.service;

import com.os.manager.request.AddPriceRequest;
import com.os.manager.request.DeletePriceRequest;
import com.os.manager.request.UpdatePriceRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 * @ClassName: PriceService
 * @Description:TODO(价格体系)
 * @author: 陆晨曦
 * @date: 2019年1月5日 下午2:04:27
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface PriceService
{
	/**
	 * 
	 * @Title: queryPiceConfig @Description: TODO(查询价格体系配置) @param: @param
	 *         request @param: @return @return: TableDataResp @throws
	 */
	TableDataResp queryPiceConfig(BaseTableRequest request);

	/**
	 * 
	 * @Title: addPriceConfig @Description: TODO(添加价格体系) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp addPriceConfig(AddPriceRequest request);

	/**
	 * 
	 * @Title: updatePriceConfig @Description: TODO(修改价格体系) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp updatePriceConfig(UpdatePriceRequest request);

	/**
	 * 
	 * @Title: deletePriceConfig @Description: TODO(删除价格体系配置) @param: @param
	 * request @param: @return @return: BaseResp @throws
	 */
	BaseResp deletePriceConfig(DeletePriceRequest request);
}
