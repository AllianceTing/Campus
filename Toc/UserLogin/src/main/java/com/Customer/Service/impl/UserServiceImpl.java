package com.Customer.Service.impl;


import com.Customer.Exception.ErrorCode;
import com.Customer.Exception.ResultUtils;
import com.Customer.Mapper.UserMapper;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.chains.UserLoginReuestContent;
import com.Customer.strategy.LoginTypeEnum;
import com.Customer.strategy.strategyContent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-01-29 15:59:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByAccount(String userAccount) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("userAccount", userAccount);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User selectUserByEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        return userMapper.selectOne(queryWrapper);
    }


    public Object doUserLogin(UserLoginReuestContent userVo, LoginTypeEnum strategyName) {
        boolean flag = strategyContent.getLoginStrategy(strategyName).loginStrategy(userVo);
        if (flag != true) {
            //todo registry
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    public QueryWrapper<User> getListUserPage(UserLoginReuestContent userVo) {
        QueryWrapper<User> UserBasequeryWrapper = new QueryWrapper();
        UserBasequeryWrapper.eq("userAccount", userVo.getUserAccount());
        UserBasequeryWrapper.eq("userPassword", userVo.getUserPassword());
        return UserBasequeryWrapper;
    }
}




