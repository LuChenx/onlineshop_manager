
package com.os.manager.aspect;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.os.manager.response.base.BaseResp;
import com.os.manager.response.base.ReturnCode;

/**
 * 
 * @ClassName: LogAspect
 * @Description:TODO(aop切入点)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:50:35
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Aspect
@ Component
public class LogAspect
{
	private Logger logger = LogManager.getLogger(LogAspect.class);

	@ Pointcut ("@annotation(com.os.manager.aspect.ControllerLogger)")
	public void controllerAspect()
	{
		logger.info("Controller层接口调用日志切入点");
	}

	/**
	 * 前置通知（Before advice） ：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。
	 * 
	 * @param joinPoint
	 */
	@ Before ("controllerAspect()")
	public void before(JoinPoint joinPoint) throws RequestParamValidException
	{
		// 获取连接点方法的入参列表
		Object[] params = joinPoint.getArgs();
		List<String> paramStr = new ArrayList<>();
		for(Object arg : params)
		{
			if(arg != null)
			{
				if(arg instanceof String)
				{
					paramStr.add(String.valueOf(arg));
				}
				else if(arg instanceof BindingResult)
				{
					BindingResult result = (BindingResult) arg;
					BaseResp errorMap = this.validRequestParams(result);
					if(errorMap != null)
					{
						ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes();
						HttpServletResponse response = res.getResponse();
						response.setCharacterEncoding("UTF-8");
						response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
						response.setStatus(HttpStatus.OK.value());
						OutputStream output = null;
						String error = "";
						try
						{
							output = response.getOutputStream();
							error = JSON.toJSONString(errorMap);
							output.write(error.getBytes("UTF-8"));
						}
						catch (IOException e)
						{
							logger.error(e.getMessage());
						}
						finally
						{
							try
							{
								if(output != null)
								{
									output.close();
								}
							}
							catch (IOException e)
							{
								logger.error(e.getMessage());
							}
						}
						throw new RequestParamValidException(error);
					}
				}
				else
				{
					paramStr.add(arg.toString());
				}
			}
		}
		// 获取连接点方法的签名
		Signature signature = joinPoint.getSignature();
		// 方法名
		String method = signature.getName();
		// 类名
		String className = signature.getDeclaringTypeName();
		// 接口日志输出
		logger.info(className + "." + method + "|| req:{ " + paramStr.toString() + "}");
	}

	/**
	 * 校验
	 */
	private BaseResp validRequestParams(BindingResult result)
	{
		if(result.hasErrors())
		{
			List<ObjectError> allErrors = result.getAllErrors();
			StringBuffer msg = new StringBuffer();
			for(ObjectError objectError : allErrors)
			{
				msg.append(objectError.getDefaultMessage() + ",");
			}
			String resMsg = msg.substring(0, msg.length() - 1);
			BaseResp recvInfo = new BaseResp(ReturnCode.CODE_199990, resMsg);
			return recvInfo;
		}
		return null;
	}

	/**
	 * 后通知（After advice） ：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
	 * 
	 * @param joinPoint
	 */
	@ AfterReturning (returning = "rvt" ,pointcut = "controllerAspect()")
	public void doAfter(JoinPoint joinPoint , Object rvt)
	{
		String result = "";
		if(rvt instanceof String)
		{
			result = String.valueOf(rvt);
		}
		else if(rvt == null)
		{
			result = "void";
		}
		else
		{
			result = rvt.toString();
		}
		// 获取连接点方法的签名
		Signature signature = joinPoint.getSignature();
		// 方法名
		String method = signature.getName();
		// 类名
		String className = signature.getDeclaringTypeName();
		logger.info(className + "." + method + "|| res:{ " + result + "}");
	}

	/**
	 * 抛出异常后通知（After throwing advice） ： 在方法抛出异常退出时执行的通知。
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@ AfterThrowing (value = "controllerAspect()" ,throwing = "e")
	public void doAfter(JoinPoint joinPoint , Exception e)
	{
		// 获取连接点方法的签名
		Signature signature = joinPoint.getSignature();
		// 方法名
		String method = signature.getName();
		// 类名
		String className = signature.getDeclaringTypeName();
		logger.info(className + "." + method + "|| Exception:{ " + e.getMessage() + "}");
	}

	/**
	 * 获得注解
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private static ControllerLogger giveController(JoinPoint joinPoint) throws Exception
	{
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if(method != null)
		{
			return method.getAnnotation(ControllerLogger.class);
		}
		return null;
	}
}
