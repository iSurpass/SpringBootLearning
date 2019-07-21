package com.juniors.controller;

import com.juniors.service.AsyncService;
import com.juniors.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

/**
 * @author Juniors
 */
@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @Autowired
    MailService mailService;

    @GetMapping("/hello")
    public String hello(){

        asyncService.hello();
        return "success";
    }

    @GetMapping("/lakers")
    public String lakers(){

        try {
            mailService.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
