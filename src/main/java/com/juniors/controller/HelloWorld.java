package com.juniors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Juniors
 */
@Controller
public class HelloWorld {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/jdbc")
    @ResponseBody
    public Map<String,Object> jdbc(){

        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Juniors!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){

        map.put("hello","Welcome to Juniors");
        map.put("users",Arrays.asList("Juniors","Harden","Kobe"));
        return "success";
    }

    @RequestMapping("/crud")
    public String login(){

        return "index";
    }
}
