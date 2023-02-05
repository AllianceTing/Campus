package com.Customer.strategy;

import com.Customer.PiplineValidate.PipelineExecutor;
import com.Customer.PiplineValidate.UserLoginReuestContent;
import com.Customer.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME loginStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByWeChat implements loginStrategy {

    @Resource
    PipelineExecutor pipelineExecutor;
    @Resource
    UserService userService;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        return pipelineExecutor.acceptSync(data);
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.WeChatLogin;
    }
}
