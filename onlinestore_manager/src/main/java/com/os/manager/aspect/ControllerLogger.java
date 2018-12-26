
package com.os.manager.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: ControllerLogger
 * @Description:TODO(自定义注解，用于接口调用日志)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:49:55
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Retention (RetentionPolicy.RUNTIME)
// 注解会在class中存在，运行时可通过反射获取
@ Target (ElementType.METHOD)
// 目标是方法
@ Documented
public @interface ControllerLogger
{}
