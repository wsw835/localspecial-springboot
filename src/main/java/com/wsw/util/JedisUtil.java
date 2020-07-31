package com.wsw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    public static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    // Jedispool
    JedisCommands jedisCommands;
    JedisPool jedisPool;
    Jedis jedis;
    // common-pool 连接池配置，
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    String ip = "127.0.0.1";
    int port = 6379;
    int timeout = 2000;

    public Jedis init() {
        // 初始化jedis
        // 设置配置
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnReturn(true);
        // 初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout);
        jedis = jedisPool.getResource();
        jedisCommands = jedis;
        return jedis;
    }

    public void setValue(String key, String value) {
        this.jedisCommands.set(key, value);
    }

    public String getValue(String key) {
        return this.jedisCommands.get(key);
    }

   /* public static void main(String[] args) {
        JedisUtil testJedis = new JedisUtil();
        testJedis.init();
        testJedis.setValue("testJedisKey", "JedisValue");
        logger.info("get value from redis:{}", testJedis.getValue("testJedisKey"));
    }*/
}
