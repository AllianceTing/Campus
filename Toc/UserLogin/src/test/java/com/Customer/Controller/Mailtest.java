package com.Customer.Controller;

import com.Customer.Service.RegistryMailService;
import lombok.Synchronized;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PROJECT_NAME Mailtest
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:51
 */
@SpringBootTest
public class Mailtest {
    @Test
    void re() {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(()->{
            // insert
            System.out.println(atomicInteger);
        },"m1");
    };

};

