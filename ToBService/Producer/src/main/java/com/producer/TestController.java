package com.producer;

import com.producer.Service.ProducerSendSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PROJECT_NAME TestController
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~17:30
 */
@RestController
public class TestController {
    @Resource
    ProducerSendSerivce producerSendSerivce;

    @GetMapping("/producer")
    public void TestKafkaController() {
        producerSendSerivce.sendAsyncMail("18080266036");
    }
}
