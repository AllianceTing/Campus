package com.Customer.util;

import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    PipelineExcutor Pipelin;

    @Test
    void test() {
        UserLoginReuestContent user = new UserLoginReuestContent();
        user.setUserAccount("u");
        user.setUserPassword("p");
        user.setEmail("2426446427@qq.com");
        boolean b = Pipelin.acceptSync(user);
        System.out.println(b);
    }
}
