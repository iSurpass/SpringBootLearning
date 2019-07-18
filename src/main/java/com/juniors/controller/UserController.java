package com.juniors.controller;

import com.juniors.vo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Juniors
 */
@Controller
public class UserController {

    @PostMapping(value = "/user/login")
    public String login(LoginVo vo, Map<String,Object> map, HttpSession session) {

        if (vo.getPassword().equals("123456")) {
            // 为防止重复提交表单，进行重定向处理
            session.setAttribute("loginUser", vo.getUsername());
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
            return "index";
        }
    }
}
