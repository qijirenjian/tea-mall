package com.ren.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author renjian
 * @creaate 2021-04-23 10:19
 * function
 * description
 * -
 */


public class jedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.157.129",6379);

//      测试连通
        System.out.println(jedis.ping());


        jedis.set("k11","123");
        System.out.println(jedis.get("k1"));



//        事务
        Transaction transaction = jedis.multi();

        transaction.set("k4","4");
        transaction.set("k5","5");
        transaction.exec();
//        transaction.discard();  放弃


    }

}
