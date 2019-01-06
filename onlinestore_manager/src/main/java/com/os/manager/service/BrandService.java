
package com.os.manager.service;

import com.os.manager.request.AddBrandRequest;
import com.os.manager.request.DeleteBrandRequest;
import com.os.manager.request.UpdateBrandRequest;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 * @ClassName: BrandService
 * @Description:TODO(商品管理)
 * @author: 陆晨曦
 * @date: 2019年1月6日 下午5:53:24
 * 
 * @Copyright: 2019 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public interface BrandService
{
	/**
	 * 
	 * @Title: queryBrandConfig @Description: TODO(查询商品配置) @param: @param
	 *         request @param: @return @return: TableDataResp @throws
	 */
	TableDataResp queryBrandConfig(BaseTableRequest request);

	/**
	 * 
	 * @Title: addBrandConfig @Description: TODO(添加商品配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp addBrandConfig(AddBrandRequest request);

	/**
	 * 
	 * @Title: updateBrandConfig @Description: TODO(更新商品配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp updateBrandConfig(UpdateBrandRequest request);

	/**
	 * 
	 * @Title: deleteBrandConfig @Description: TODO(删除商品配置) @param: @param
	 *         request @param: @return @return: BaseResp @throws
	 */
	BaseResp deleteBrandConfig(DeleteBrandRequest request);
}
