package com.producer.Service;

import com.producer.KEY.CallBackKEYS;
import com.producer.KEY.ProducerKEYS;
import com.producer.KEY.TopicKEYS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * PROJECT_NAME ProducerSendServiceIMPL
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~17:09
 */
@Service
public class ProducerSendServiceIMPL implements ProducerSendSerivce {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(ProducerSendServiceIMPL.class);

    public void sendAsyncMail(String UKey) {
        String concat = UKey.concat("mail");
        kafkaTemplate.send(TopicKEYS.MAIL_TOPIC, concat, UKey).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error(CallBackKEYS.SUCCESS_KEY, ex.fillInStackTrace());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                logger.info(CallBackKEYS.SUCCESS_KEY, result);
            }
        });
    }

    public void sendAsyncMessage(String UKey) {
//        Properties properties = mailHeadTemp.doProducerSendMail();
        kafkaTemplate.send(TopicKEYS.MESSAGE_TOPIC, ProducerKEYS.MAIL_KEY, null).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error(CallBackKEYS.SUCCESS_KEY, ex.fillInStackTrace());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                logger.info(CallBackKEYS.SUCCESS_KEY, result);
            }
        });
    }
}
