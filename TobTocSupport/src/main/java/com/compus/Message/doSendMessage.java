package com.compus.Message;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT_NAME doSendMessage
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~11:52
 */
@Component
public class doSendMessage {
    @Resource
    MessageConfigrationProcessor messageConfigrationProcessor;

    public void doKafkaSendMessage() {
        var messageAppcode = messageConfigrationProcessor.getMessageAppcode();
        var messagePath = messageConfigrationProcessor.getMessagePath();
        var messageMethod = messageConfigrationProcessor.getMessageSendMethod();
        var messagePost = messageConfigrationProcessor.getMessageSendByPost();
        var messageHost = messageConfigrationProcessor.getMessageHostIp();
        var messageSmsSignId = messageConfigrationProcessor.getMessageSmsSignId();
        var messageTemplateId = messageConfigrationProcessor.getMessageTemplateId();
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + messageAppcode);
        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("mobile", number);
//        querys.put("param", "**code**:" + authCode + time);
        //smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html
        querys.put("smsSignId", messageSmsSignId);
        querys.put("templateId", messageTemplateId);
    }
}

