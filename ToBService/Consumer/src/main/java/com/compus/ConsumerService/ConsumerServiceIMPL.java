package com.compus.ConsumerService;

import com.compus.Mail.doSendMailService;
import com.compus.Message.doSendMessageService;
import com.compus.TopicConfigration.TopicKEYS;
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
    doSendMessageService doSendMessageService;
    @Resource
    doSendMailService doSendMailService;

    //todo 公共抽取topics -- > meta-inf spring factory
    @KafkaListener(topics = {TopicKEYS.MAIL_TOPIC})
    public void doConsumeKafkaMail(ConsumerRecord<String, String> record) throws Exception {
        String value = record.value();
        System.out.println(value);
        // 比对下这个类型的bean
        doSendMailService.doProducerSendMail();
    }

    @KafkaListener(topics = {TopicKEYS.MESSAGE_TOPIC})
    public void doConsumeKafkaMessage(ConsumerRecord<String, String> record) throws Exception {
        String value = record.value();
        //todo 此处的phone 是record里取出来的
        doSendMessageService.smsSendMessage("18080266036");
    }
}
