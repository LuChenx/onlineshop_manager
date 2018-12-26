
package com.os.manager.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Jedis工具
 *
 * <p>Title: Jedis.java</p> <p>Description: Jedis.java</p> <p>Copyright:
 * Copyright (c) 2018</p> <p>Company: FPI </p>
 * @author luchenxi
 * @version 1.0
 * @creattime 2018年12月26日 下午1:22:22
 */
@ Component
public class RedisClient
{
	@ Autowired
	private JedisPool jedisPool;

	private Jedis getJedis()
	{
		return jedisPool.getResource();
	}

	public String set(String key , String value)
	{
		Jedis jedis = getJedis();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	public String set(byte[] key , byte[] value)
	{
		Jedis jedis = getJedis();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	public String get(String key)
	{
		Jedis jedis = getJedis();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	public byte[] get(byte[] key)
	{
		Jedis jedis = getJedis();
		byte[] result = jedis.get(key);
		jedis.close();
		return result;
	}

	public Long del(String key)
	{
		Jedis jedis = getJedis();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public Long del(byte[] key)
	{
		Jedis jedis = getJedis();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public Long del(String... keys)
	{
		Jedis jedis = getJedis();
		Long result = jedis.del(keys);
		jedis.close();
		return result;
	}

	public Long del(byte[]... keys)
	{
		Jedis jedis = getJedis();
		Long result = jedis.del(keys);
		jedis.close();
		return result;
	}

	public Boolean exists(String key)
	{
		Jedis jedis = getJedis();
		Boolean result = jedis.exists(key);
		jedis.close();
		return result;
	}

	public Long expire(String key , int seconds)
	{
		Jedis jedis = getJedis();
		Long result = jedis.expire(key, seconds);
		jedis.close();
		return result;
	}

	public Long expire(byte[] key , int seconds)
	{
		Jedis jedis = getJedis();
		Long result = jedis.expire(key, seconds);
		jedis.close();
		return result;
	}

	public Long ttl(String key)
	{
		Jedis jedis = getJedis();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	public Long incr(String key)
	{
		Jedis jedis = getJedis();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	public Long hset(String key , String field , String value)
	{
		Jedis jedis = getJedis();
		Long result = jedis.hset(key, field, value);
		jedis.close();
		return result;
	}

	public String hget(String key , String field)
	{
		Jedis jedis = getJedis();
		String result = jedis.hget(key, field);
		jedis.close();
		return result;
	}

	public Map<String , String> hgetAll(String key)
	{
		Jedis jedis = getJedis();
		Map<String , String> result = jedis.hgetAll(key);
		jedis.close();
		return result;
	}

	public Long hdel(String key , String... fields)
	{
		Jedis jedis = getJedis();
		Long result = jedis.hdel(key, fields);
		jedis.close();
		return result;
	}
}
