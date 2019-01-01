
package com.os.manager.utils;
/**
 * 
 * @ClassName: JsonArrayUtils
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 陆晨曦
 * @date: 2018年12月31日 下午12:52:17
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class JsonArrayUtils
{
	public static <T> JSONArray conver(List<T> list)
	{
		JSONArray array = new JSONArray();
		list.forEach(em -> {
			array.add(em);
		});
		return array;
	}
}
