package com.compus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PROJECT_NAME TocApplication
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~22:23
 */
@SpringBootApplication
public class TocApplication {
    public static void main(String[] args) {
        SpringApplication.run(TocApplication.class, args);
        System.out.println(SpringApplication.run(TocApplication.class, args).getBeanDefinitionNames());

    }
}
