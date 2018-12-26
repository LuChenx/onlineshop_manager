
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
 * Jedis配置
 *
 * <p>Title: JedisConfig.java</p> <p>Description: JedisConfig.java</p>
 * <p>Copyright: Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:14:59
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
