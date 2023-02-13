package com.compus.Mail;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * PROJECT_NAME MessageConfigrationProcessor
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~11:17
 */
@Component(value = "MailConfigrationProcessor")
@ConfigurationProperties(prefix = "mail")
@Data
public class MailConfigrationProcessor {
    @Value("${mail.mail-send-smtp-server}")
    private String mailSendSmtpServer;
    @Value("${mail.mail-s-m-t-p}")
    private String mailSMTP;
    @Value("${mail.mail-port}")
    private String mailPort;
    @Value("${mail.mail-auth}")
    private String mailAuth;
    @Value("${mail.mail-send-host}")
    private String mailSendHost;

}
