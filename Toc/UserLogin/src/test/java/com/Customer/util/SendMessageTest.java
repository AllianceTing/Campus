package com.Customer.util;

import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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

    @Test
    void userAccount() {
        String phoneNumber = "18080266036";
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phoneNumber);
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
    }
}
