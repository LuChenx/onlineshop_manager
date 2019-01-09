
package com.os.manager.response;

import java.util.List;

import com.os.manager.dbmodel.SysConfigSettingType;
import com.os.manager.response.base.BaseResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @ClassName: SystemOptionTypeResp
 * @Description:TODO(系统选项类型)
 * @author: 陆晨曦
 * @date: 2018年12月30日 下午8:05:57
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
@ ToString (callSuper = true)
public class SystemOptionTypeResp extends BaseResp
{
	List<SysConfigSettingType> settingTypes;
}
