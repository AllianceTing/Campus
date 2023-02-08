package com.Customer.UserLoginMoudle.strategy;

import lombok.NonNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT_NAME RegistrystrategyContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:03
 */
@Component
public class strategyContent implements InitializingBean, ApplicationContextAware {
    private static final Map<LoginTypeEnum, loginStrategy> loginStrategies = new HashMap<>();

    private ApplicationContext appContext;

    public static loginStrategy doUserLogin(LoginTypeEnum LoginType) {
        if (LoginType == null) {
            throw new IllegalArgumentException("Login type is empty.");
        }
        if (!loginStrategies.containsKey(LoginType)) {
            throw new IllegalArgumentException("Login type not supported.");
        }
        return loginStrategies.get(LoginType);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        appContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        // 将 Spring 容器中所有的 Payment 接口实现类注册到 payStrategies
        appContext.getBeansOfType(loginStrategy.class)
                .values()
                .forEach(loginStrategy -> loginStrategies.put(loginStrategy.getloginType(), loginStrategy));
    }
}

