package com.compus.Mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * PROJECT_NAME doSendMailService
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~11:53
 */
@Service
public class doSendMailService {
    @Value("${mail.mail-send-host}")
    String mailSendUser;
    @Value("${mail.mail-s-m-t-p}")
    String mailSMTP;
    @Value("${mail.mail-auth}")
    String mailAuth;
    @Value("${mail.mail-send-smtp-server}")
    String mailServer;
    @Value("${mail.mail-port}")
    String mailPort;

    public void doProducerSendMail() {
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", mailAuth);
        //此处填写SMTP服务器
        props.put("mail.smtp.host", mailServer);
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", mailPort);
        // 此处填写，写信人的账号
        props.put("mail.user", mailSendUser);
        // 此处填写16位SMTP口令
        props.put("mail.password", mailSMTP);//创建邮件消息
    }
}
