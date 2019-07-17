package com.juniors.controller;

import com.juniors.vo.LoginVo;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< Updated upstream
=======
import javax.servlet.http.HttpSession;
import java.util.Map;

>>>>>>> Stashed changes
/**
 * @author Juniors
 */
@RestController
@RequestMapping("/user")
public class UserController {

<<<<<<< Updated upstream
    @PutMapping("/login")
    public String login(LoginVo vo){
=======
    @PostMapping(value = "/user/login")
    public String login(LoginVo vo, Map<String,Object> map, HttpSession session){

        if (vo.getPassword().equals("123456")){
            // 为防止重复提交表单，进行重定向处理
            session.setAttribute("loginUser",vo.getUsername());
            return "redirect:/main.html";

        }else {
            map.put("msg","用户名密码错误");
            return "index";
        }
>>>>>>> Stashed changes

        return "login";
    }
}
