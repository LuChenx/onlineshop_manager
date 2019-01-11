
package com.os.manager.service;

import com.os.manager.request.AddSystemOptionRequest;
import com.os.manager.request.DeleteOptionRequest;
import com.os.manager.request.SystemOptionRequest;
import com.os.manager.request.UpdateSystemConfigRequest;
import com.os.manager.request.UpdateSystemOptionRequest;
import com.os.manager.request.base.BaseResq;
import com.os.manager.request.base.BaseTableRequest;
import com.os.manager.response.SystemOptionTypeResp;
import com.os.manager.response.TableDataResp;
import com.os.manager.response.base.BaseResp;

/**
 * 
 *
 * <p>Title: SystemConfigService.java</p> <p>Description:
 * SystemConfigService.java</p> <p>Copyright: Copyright (c) 2019</p> <p>Company:
 * FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2019年1月9日 上午11:35:52
 */
public interface SystemConfigService
{
	/**
	 * 查询系统选项类型
	 * @param request
	 * @return
	 */
	SystemOptionTypeResp queryOptionTypeList(BaseResq request);

	/**
	 * 查询系统配置选项
	 * @param request
	 * @return
	 */
	TableDataResp querySystemOptions(SystemOptionRequest request);

	/**
	 * 添加系统选项
	 * @param request
	 * @return
	 */
	BaseResp addSystemOption(AddSystemOptionRequest request);

	/**
	 * 删除系统选项
	 * @param request
	 * @return
	 */
	BaseResp deleteOptionConfig(DeleteOptionRequest request);

	/**
	 * 更新系统选项
	 * @param request
	 * @return
	 */
	BaseResp updateOptionConfig(UpdateSystemOptionRequest request);

	/**
	 * 查询系统配置表
	 * @param request
	 * @return
	 */
	TableDataResp systemConfig(BaseTableRequest request);

	/**
	 * 更新系统配置
	 * @param request
	 * @return
	 */
	BaseResp updateSystemConfig(UpdateSystemConfigRequest request);
}
