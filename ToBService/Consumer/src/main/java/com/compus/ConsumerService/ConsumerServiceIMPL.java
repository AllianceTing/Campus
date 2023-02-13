package com.compus.ConsumerService;

import com.compus.Mail.mailHeadTemp;
import com.compus.Message.doSendMessage;
import com.compus.TopicKEYS;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PROJECT_NAME ConsumerServiceIMPL
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~20:20
 */
@Service
public class ConsumerServiceIMPL {
    @Resource
    doSendMessage doSendMessage;
    @Resource
    mailHeadTemp mailHeadTemp;

    //todo 公共抽取topics -- > meta-inf spring factory
    @KafkaListener(topics = {TopicKEYS.MAIL_TOPIC})
    public void doConsumeKafkaMail(ConsumerRecord<String, String> record) throws Exception {
        String value = record.value();
        System.out.println(value);
        // 比对下这个类型的bean
        mailHeadTemp.doProducerSendMail();
    }

    @KafkaListener(topics = {TopicKEYS.MESSAGE_TOPIC})
    public void doConsumeKafkaMessage(ConsumerRecord<String, String> record) {
        String value = record.value();
    }
}
