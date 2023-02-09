package com.Customer.Service;

import com.Customer.PO.User;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * PROJECT_NAME com.Customer.UserService
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~15:55
 */

public interface UserService extends IService<User> {
    User selectUserByAccount(String userAccount);

    User selectUserByEmail(String email);

    Object doUserLogin(UserLoginReuestContent userVo, LoginTypeEnum strategyName);

    Object doUserLogOut(UserLoginReuestContent userVo);

}
