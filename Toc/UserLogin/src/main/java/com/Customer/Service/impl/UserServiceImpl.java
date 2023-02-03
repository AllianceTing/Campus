package com.Customer.Service.impl;


import com.Customer.Mapper.UserMapper;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.VO.UserVo;
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

    public void doUserLogin(UserVo userVo) {
    }

    @Override
    public User selectUserByAccount(String userAccount) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("userAccount",userAccount);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User selectUserByEmail(String email) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("email",email);
        return userMapper.selectOne(queryWrapper);
    }
}




