
package com.os.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName: BaseResq
 * @Description:TODO(树)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:42:42
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Data
@ AllArgsConstructor
@ NoArgsConstructor
public class Node
{
	public long   nodeId;    //树的节点Id;
	public String text;       //节点名称
	// public List<Node> nodes;    //子节点，可以用递归的方法读取，
}
