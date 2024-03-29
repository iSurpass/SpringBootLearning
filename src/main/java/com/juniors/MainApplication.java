package com.juniors;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

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
@EnableAsync
@EnableScheduling
public class MainApplication{

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class,args);

    }
}
