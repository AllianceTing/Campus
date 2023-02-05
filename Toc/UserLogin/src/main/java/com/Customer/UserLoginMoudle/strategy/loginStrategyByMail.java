package com.Customer.UserLoginMoudle.strategy;

import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.util.SendMessage;
import com.Customer.util.kaotchaUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;


/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByMail implements loginStrategy {
    @Resource
    PipelineExcutor pipelineExecutor;
    @Resource
    UserService userService;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        kaotchaUtils kaotchaUtils = new kaotchaUtils();
        String TextCode = "";
        try {
            TextCode = kaotchaUtils.captchaCodeCreator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SendMessage.Send(data.getEmail(), TextCode);
        QueryWrapper<User> query = new QueryWrapper<User>();
        query.eq("email", data.getEmail());
        User userServiceOne = userService.getOne(query);
        if (userServiceOne != null) {
            if (data.getEmailCode() == TextCode) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MailLogin;
    }
}
