package com.Customer.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void test() throws MessagingException {
        String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
        SendEmail.sendEmail("1940844289@qq.com",emailCode);

    }
}