package com.Customer.UserLoginMoudle.strategy;

import com.Customer.Mapper.UserMapper;
import com.Customer.PO.User;
import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByAccount implements loginStrategy {
    @Resource
    PipelineExcutor pipelineExecutor;
    @Resource
    UserMapper userService;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        if (pipelineExecutor.acceptSync(data)) {
            QueryWrapper<User> query = new QueryWrapper<User>();
            query.eq("userAccount", data.getUserAccount());
            query.eq("userPassword", data.getUserPassword());
            User userServiceOne = userService.selectOne(query);
            if (userServiceOne != null) {
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
