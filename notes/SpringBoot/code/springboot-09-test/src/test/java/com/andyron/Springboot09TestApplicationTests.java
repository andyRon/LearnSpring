package com.andyron;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        // 简单邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("小戎你好啊");
        mailMessage.setText("这是自娱自乐的邮件");
        mailMessage.setFrom("672757730@qq.com");
        mailMessage.setTo("672757730@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        // 复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 正文
        helper.setSubject("小戎你好啊~+++");
        helper.setText("<p style='color:blue;'>这是自娱自乐的邮件</p>", true);
        // 附件
        helper.addAttachment("1.jpg",new File("/Users/andyron/Downloads/1.jpg"));
        helper.addAttachment("2.jpg",new File("/Users/andyron/Downloads/1.jpg"));

        helper.setTo("672757730@qq.com");
        helper.setFrom("672757730@qq.com");

        mailSender.send(mimeMessage);
    }

}
