package com.juniors.controller;

import com.juniors.model.Book;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Juniors
 */
@Controller
public class RabbitMQController {

    // 给 RabbitMQ 发送和接受消息
    @Autowired
    RabbitTemplate rabbitTemplate;

    // RabbitMQ 系统管理功能组件
    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 单播方式发送消息
     *
     * @return
     */
    @RequestMapping("/direct")
    public String direct(){

        // 创建单播路由器
        amqpAdmin.declareExchange(new DirectExchange("amqp.exchange"));

        // 创建队列
        amqpAdmin.declareQueue(new Queue("amqp.queue",true));

        //创建绑定关系
        amqpAdmin.declareBinding(new Binding("amqp.queue",Binding.DestinationType.QUEUE,"amqp.exchange","amqp.haha",null));

        System.out.println("Create Success!");

        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("hello,JuniorsMVP",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","juniors.news",new Book(1,"西游记","吴承恩"));

        //接收数据
        /*Object o = rabbitTemplate.receiveAndConvert("juniors.news");
        System.out.println(o.getClass());
        System.out.println(o);*/
        return "success";
    }
}
