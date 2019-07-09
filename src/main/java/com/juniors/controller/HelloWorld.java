package com.juniors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Juniors
 */
@Controller
public class HelloWorld {

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
