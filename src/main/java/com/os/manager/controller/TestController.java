
package com.os.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.manager.aspect.ControllerLogger;
import com.os.manager.redis.RedisClient;
import com.os.manager.respnse.base.ReturnCode;
import com.os.manager.response.TestResp;

/**
 * 测试用
 *
 * <p>Title: TestController.java</p> <p>Description: TestController.java</p>
 * <p>Copyright: Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:39:53
 */
@ RestController
@ RequestMapping (value = "/test")
public class TestController
{
	@ Autowired
	RedisClient redisClient;

	@ ControllerLogger
	@ RequestMapping (value = "/test")
	public TestResp test()
	{
		TestResp resp = new TestResp();
		resp.setRcode(ReturnCode.CODE_000000);
		resp.setRmsg(ReturnCode.INFO_000000);
		resp.setSystemName("onlinestore");
		resp.setVarsion("1.1.0");
		redisClient.set("test", "test");
		return resp;
	}
}
