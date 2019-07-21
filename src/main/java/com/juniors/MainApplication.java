package com.juniors;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringBoot项目启动主程序类
 * @author Juniors
 */
@SpringBootApplication
/**
 * 缓存操作记得加该注解
 */
@EnableCaching
@EnableRabbit
public class MainApplication {

    public static void main(String[] args) {

        //Spring 应用启动起来
        SpringApplication.run(MainApplication.class,args);
    }
}
