package com.Customer.util;

import com.Customer.Exception.BusinessException;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.concurrent.ThreadLocalRandom;

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
    @Resource
    UserService userService;
    @Resource
    PipelineExcutor pipelineExecutor;

    @Test
    void userAccount() {
//        UserLoginReuestContent data = new UserLoginReuestContent();
//        data.setUserAccount("username");
//        data.setEmail("2426446427@qq.com");
//        data.setUserPassword("password");
//
//        if (true) {
//            User retUser = userService.selectUserByEmail(data.getEmail());
//            if (retUser != null) {
//                //如果已经使用邮箱返回账号
//                throw new BusinessException("account is already used by  user", 50400, "Invalid email");
//            }
//            //todo
//            String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
//            try {
//                //SendEmail.sendEmail(data.getEmail(), emailCode);
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (emailCode == data.getEmail()) {
//                System.out.println(emailCode);
//            }
//        }
    }
}
