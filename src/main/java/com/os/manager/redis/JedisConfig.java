
package com.os.manager.redis;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName: JedisConfig
 * @Description:TODO(jedis配置)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:51:47
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
@ Configuration
public class JedisConfig extends CachingConfigurerSupport
{
	private Logger logger = LogManager.getLogger(JedisConfig.class);
	/**
	 * 获取配置
	 */
	@ Value ("${redis.hostName}")
	private String host;
	@ Value ("${redis.port}")
	private int    port;
	@ Value ("${redis.timeout}")
	private int    timeout;
	@ Value ("${redis.maxTotal}")
	private int    maxActive;
	@ Value ("${redis.maxIdle}")
	private int    maxIdle;
	@ Value ("${redis.minIdle}")
	private int    minIdle;
	@ Value ("${redis.maxWaitMillis}")
	private long   maxWaitMillis;

	/**
	 * 
	 * @Title: redisPoolFactory @Description:
	 * TODO(初始化redis连接池) @param: @return @return: JedisPool @throws
	 */
	@ Bean
	public JedisPool redisPoolFactory()
	{
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setMaxTotal(maxActive);
		jedisPoolConfig.setMinIdle(minIdle);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
		logger.debug("JedisPool注入成功！");
		return jedisPool;
	}
}
