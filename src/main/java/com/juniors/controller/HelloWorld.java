package com.juniors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
