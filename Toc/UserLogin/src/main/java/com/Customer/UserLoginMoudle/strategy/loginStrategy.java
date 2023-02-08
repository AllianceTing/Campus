package com.Customer.UserLoginMoudle.strategy;

import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;

/**
 * PROJECT_NAME RegistryStrategy
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~11:59
 */
public interface loginStrategy {
    boolean loginStrategy(UserLoginReuestContent data);

    LoginTypeEnum getloginType();
}
