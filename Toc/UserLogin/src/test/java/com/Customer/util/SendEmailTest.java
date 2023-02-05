package com.Customer.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-02
 * Time:19:30
 *
 * @Author: 东莞呵呵
 */
@SpringBootTest
class SendEmailTest {

    @Autowired
    private SendEmail sendEmail;
    @Resource
    private SendMessage sendMessage;
    @Test
    void test() throws MessagingException {
//        String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
//        sendEmail.sendEmail("1940844289@qq.com","666666");
        sendMessage.Send("18864691986","666666");

    }
}