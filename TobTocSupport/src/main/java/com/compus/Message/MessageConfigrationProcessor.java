package com.compus.Message;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * PROJECT_NAME MessageConfigrationProcessor
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~11:17
 */
@Component
@ConfigurationProperties(prefix = "message")
@Data
public class MessageConfigrationProcessor {

    private String messageSendByPost;

    private String messageSMTP;

    private String messageHostIp;

    private String messageSendMethod;

    private String messageAppcode;

    private String messageSmsSignId;

    private String messageTemplateId;

    private String messageAuthCodeTime;

    private String messagePath;
}
