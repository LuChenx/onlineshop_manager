
package com.os.manager.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 *
 * <p>Title: UploadExcelRequest.java</p> <p>Description:
 * UploadExcelRequest.java</p> <p>Copyright: Copyright (c) 2019</p> <p>Company:
 * FPI </p>
 * @author 18163
 * @version 1.0
 * @creattime 2019年1月19日 上午10:49:21
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
@ ToString (callSuper = true)
public class UploadExcelRequest
{
	String rows;
}
