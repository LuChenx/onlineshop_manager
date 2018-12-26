
package com.os.manager.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 *
 * <p>Title: ControllerLogger.java</p> <p>Description: ControllerLogger.java</p>
 * <p>Copyright: Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:39:53
 */
@ Retention (RetentionPolicy.RUNTIME)
// 注解会在class中存在，运行时可通过反射获取
@ Target (ElementType.METHOD)
// 目标是方法
@ Documented
public @interface ControllerLogger
{}
