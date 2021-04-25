package com.ren.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author renjian
 * @creaate 2021-04-23 10:58
 * function
 * description
 * -
 */


public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance(){
        if(null == jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null == jedisPool){
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxWaitMillis(100);
                    jedisPool = new JedisPool(poolConfig,"192.168.157.129",6379);
                }
            }
        }
        return  jedisPool;
    }


    public static void release(JedisPool jedisPool, Jedis jedis){
        if(null != jedis){
            jedisPool.returnResourceObject(jedis);
        }
    }
}
