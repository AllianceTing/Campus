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
    @Resource
    SendMessage sendMessage;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        if (pipelineExecutor.acceptSync(data)) {
            QueryWrapper<User> query = new QueryWrapper<User>();
            query.eq("email", data.getEmail());
            User userServiceOne = userService.getOne(query);
            if (userServiceOne != null) {
                ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                assert ra != null;
                HttpServletRequest request = ra.getRequest();
                Object verifyCode = request.getSession().getAttribute("verifyCode");
                Object verifyEmail = request.getSession().getAttribute("verifyEmail");
                if (data.getEmailCode().equals(verifyCode) && data.getEmail().equals(verifyEmail)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MailLogin;
    }
}