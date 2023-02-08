package com.Customer.util;

import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.Customer.UserLoginMoudle.strategy.strategyContent;
import org.junit.jupiter.api.Test;
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

    @Test
    void test() {
        UserLoginReuestContent user = new UserLoginReuestContent();
        user.setUserAccount("u");
        user.setUserPassword("p");
        user.setAuthCode("222222");
        user.setPhoneNumber("18080266036");
        boolean b1 = strategyContent.getLoginStrategy(LoginTypeEnum.MessageLogin).loginStrategy(user);
        System.out.println(b1);
    }
}
