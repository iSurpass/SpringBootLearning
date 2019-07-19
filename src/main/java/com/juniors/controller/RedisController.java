package com.juniors.controller;

import com.juniors.model.Employee;
import com.juniors.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juniors
 */
@Controller
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @RequestMapping("/redis")
    public String redisTest(){

        //redisTemplate.opsForValue().set("MyName","Juniors");
        stringRedisTemplate.opsForValue().set("MyName","Juniors");
        Employee employee = employeeService.getEmployee(1);

        // 当 redis 存储对象时，要先将该 POJO 类进行 Serializable（序列化）
        //redisTemplate.opsForValue().set("emp-01",employee);
        //将数据以 json 的方式保存
        //自己将对象转为 json
        //redisTemplate 默认的序列化规则，改变默认的序列化规则
        employeeRedisTemplate.opsForValue().set("emp-01",employee);

        return "index";
    }
}
