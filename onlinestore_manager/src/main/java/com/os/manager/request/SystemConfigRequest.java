
package com.os.manager.request;

import com.os.manager.request.base.BaseResq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * <p>Title: SystemConfigRequest.java</p> <p>Description:
 * SystemConfigRequest.java</p> <p>Copyright: Copyright (c) 2019</p> <p>Company:
 * FPI </p>
 * @author 18163
 * @version 1.0
 * @creattime 2019年1月19日 下午4:08:34
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class SystemConfigRequest extends BaseResq
{
	long conifgType;
}
