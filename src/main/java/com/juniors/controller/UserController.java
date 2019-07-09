package com.juniors.controller;

import com.juniors.vo.LoginVo;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juniors
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PutMapping("/login")
    public String login(LoginVo vo){

        return "login";
    }
}
