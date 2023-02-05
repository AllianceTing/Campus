package com.Customer.UserRegistryMoudle.strategy;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT_NAME RegistrystrategyContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:03
 */
@Service
public class RegistrystrategyContent {
    public static final Map<RegistryTypeEnum, RegistryStrategy> LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP = new HashMap<>();

    static {
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(RegistryTypeEnum.MailRegistry, new RegistryStrategyByMail());
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(RegistryTypeEnum.MessageRegistry, new RegistryStrategyByMessage());
        LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.put(RegistryTypeEnum.WeChatRegistry, new RegistryStrategyByWeChat());
    }

    public static RegistryStrategy getLoginStrategy(RegistryTypeEnum LoginType) {
        if (LoginType == null) {
            throw new IllegalArgumentException("Login type is empty.");
        }
        if (!LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.containsKey(LoginType)) {
            throw new IllegalArgumentException("Login type not supported.");
        }
        return LOGIN_TYPE_ENUMLOGIN_STRATEGY_MAP.get(LoginType);
    }

}

