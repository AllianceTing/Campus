package com.Customer.strategy;

import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.chains.UserLoginReuestContent;
import com.Customer.chains.pipelineExecutor;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME loginStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByAccount implements loginStrategy {

    @Resource
    pipelineExecutor pipelineExecutor;
    @Resource
    UserService userService;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        if (pipelineExecutor.acceptSync(data)) {
            QueryWrapper<User> UserBasequeryWrapper = new QueryWrapper();
            UserBasequeryWrapper.eq("userAccount", data.getUserAccount());
            UserBasequeryWrapper.eq("userPassword", data.getUserPassword());
            User userServiceOne = userService.getOne(UserBasequeryWrapper);
            if (userServiceOne != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MessageLogin;
    }
}
