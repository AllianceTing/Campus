package com.Customer;

import com.Customer.util.SendMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * PROJECT_NAME LoginApplication
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~14:14
 */
@SpringBootApplication
@EnableConfigurationProperties(SendMessage.class)
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }


}
