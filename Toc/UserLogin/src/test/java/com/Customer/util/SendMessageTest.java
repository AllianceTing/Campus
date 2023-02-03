package com.Customer.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-02
 * Time:20:32
 *
 * @Author: 东莞呵呵
 */
@SpringBootTest
class SendMessageTest {
    @Test
    void test(){
        String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
        SendMessage.Send("18864691986",authCode);
    }
}