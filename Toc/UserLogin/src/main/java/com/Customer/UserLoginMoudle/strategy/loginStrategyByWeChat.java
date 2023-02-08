package com.Customer.UserLoginMoudle.strategy;

import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByWeChat implements loginStrategy {

    @Resource
    PipelineExcutor pipelineExecutor;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        return pipelineExecutor.acceptSync(data);
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.WeChatLogin;
    }
}
