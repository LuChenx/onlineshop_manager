
package com.os.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.manager.aspect.ControllerLogger;
import com.os.manager.redis.RedisClient;
import com.os.manager.response.TestResp;
import com.os.manager.response.base.ReturnCode;

/**
 * 
 * @ClassName: TestController
 * @Description:TODO(测试用)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:51:30
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
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
