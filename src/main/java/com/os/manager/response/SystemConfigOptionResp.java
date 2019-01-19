
package com.os.manager.response;

import java.util.List;

import com.os.manager.dbmodel.SysConfigSettingOption;
import com.os.manager.response.base.BaseResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * <p>Title: SystemConfigOptionResp.java</p> <p>Description:
 * SystemConfigOptionResp.java</p> <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: FPI </p>
 * @author 18163
 * @version 1.0
 * @creattime 2019年1月19日 下午4:10:04
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class SystemConfigOptionResp extends BaseResp
{
	List<SysConfigSettingOption> options;
}
