package com.Customer.Service.impl;


import com.Customer.Exception.ErrorCode;
import com.Customer.Exception.ResultUtils;
import com.Customer.Mapper.UserMapper;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.Customer.UserLoginMoudle.strategy.strategyContent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Lenovo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-01-29 15:59:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    strategyContent strategyContent;

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
        boolean flag = strategyContent.doUserLogin(strategyName).loginStrategy(userVo);
        System.out.println(flag);
        if (flag != true) {
            //todo registry
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        return ResultUtils.success(ErrorCode.SUCCESS);
    }
}




