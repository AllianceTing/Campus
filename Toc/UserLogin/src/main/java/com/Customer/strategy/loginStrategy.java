package com.Customer.strategy;

import com.Customer.chains.UserLoginReuestContent;

/**
 * PROJECT_NAME loginStrategy
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~11:59
 */
public interface loginStrategy<T extends UserLoginReuestContent> {
    boolean loginStrategy(T data);

    LoginTypeEnum getloginType();
}
