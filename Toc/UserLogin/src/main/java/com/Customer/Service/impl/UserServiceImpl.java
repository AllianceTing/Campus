package com.Customer.Service.impl;

import com.Customer.Mapper.UserMapper;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.Customer.UserLoginMoudle.strategy.strategyContent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.compus.Exception.ErrorCode;
import com.compus.Exception.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Lenovo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-01-29 15:59:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    private static final String REDIS_PREFIX = "AUTH_PERMISSION";
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
        if (flag != true) {
            //todo registry
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
//        stringRedisTemplate.opsForValue().set(new StringBuilder().append(REDIS_PREFIX).append(userVo.getUserAccount()).toString(), userVo.getUserAccount());
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    public Object doUserLogOut(UserLoginReuestContent userVo) {
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        if (request.getCookies() == null) {
            return ResultUtils.success(ErrorCode.SUCCESS);
        }

//        String doCheckID = (String) stringRedisTemplate.opsForValue().get(new StringBuilder().append(REDIS_PREFIX).append(userVo.getUserAccount()));
//        if (doCheckID != null && doCheckID.equals(userVo.getUserAccount())) {
//            stringRedisTemplate.opsForValue().set(new StringBuilder().append(REDIS_PREFIX).append(userVo.getUserAccount()).toString(), null);
//            return ResultUtils.success(ErrorCode.SUCCESS);
//        }
        return ResultUtils.error(ErrorCode.AUTH_ERROR);
    }
}




