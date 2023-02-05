package com.Customer.UserRegistryMoudle.strategy;

import com.Customer.UserRegistryMoudle.PiplineValidate.UserRegistryRequestContent;

/**
 * PROJECT_NAME RegistryStrategy
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~11:59
 */
public interface RegistryStrategy<T extends UserRegistryRequestContent> {
    boolean loginStrategy(T data);

    RegistryTypeEnum getloginType();
}
