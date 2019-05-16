package com.sdut.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Redis
 * @Discription
 * @Author yinyuchen
 * @Date 2019/4/11 14:18
 **/
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final static Logger logger = LoggerFactory.getLogger(Example.class);

    @RequestMapping(value="/redistest")
    @CrossOrigin
    public String login(String username, String password){



        System.out.println(username+"-----"+password);

        //增
        redisTemplate.opsForValue().set(username, password);

        System.out.println("----------");

        //查
        System.out.println("----------"+redisTemplate.opsForValue().get(username));

        //删
        redisTemplate.opsForValue().getOperations().delete(username);

        System.out.println("----------"+redisTemplate.opsForValue().get(username));

        logger.info("logback 访问hello");
        logger.error("logback 访问hello");

        return "1";
    }
}
