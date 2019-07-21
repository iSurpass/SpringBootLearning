package com.juniors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Juniors
 */
@Service
public class MailService {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 简单邮件
     */
    public void sendMail(){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Woj Say ....");
        message.setText("湖人总冠军!");

        message.setTo("18652930170@163.com");
        message.setFrom("798051216@qq.com");

        mailSender.send(message);
    }

    /**
     * 复杂邮件
     * @throws MessagingException
     */
    public void send() throws MessagingException {

        // 创建一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        // 邮件基本设置

        helper.setSubject("今晚按原计划行动:");
        helper.setText("<h1 style='color:red'>给杰伦打榜!</h1>",true);

        helper.setTo("276592640@qq.com");
        helper.setFrom("798051216@qq.com");

        // 上传文件
        helper.addAttachment("photo.jpg",new File("C:\\Users\\79805\\Pictures\\photo.jpg"));

        mailSender.send(mimeMessage);

    }
}
