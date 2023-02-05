package com.Customer.UserRegistryMoudle.strategy;

import com.Customer.Service.UserService;
import com.Customer.UserRegistryMoudle.PiplineValidate.RegistryPipelineExcutor;
import com.Customer.UserRegistryMoudle.PiplineValidate.UserRegistryRequestContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class RegistryStrategyByWeChat implements RegistryStrategy {

    @Resource
    RegistryPipelineExcutor pipelineExecutor;
    @Resource
    UserService userService;

    @Override
    public boolean loginStrategy(UserRegistryRequestContent data) {
        return pipelineExecutor.acceptSync(data);
    }

    @Override
    public RegistryTypeEnum getloginType() {
        return RegistryTypeEnum.WeChatRegistry;
    }
}
