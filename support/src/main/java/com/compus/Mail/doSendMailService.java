package com.compus.Mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

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

    public void doProducerSendMail(String email) throws MessagingException {
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
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, to);
        // 设置邮件标题
        message.setSubject("验证码信息");
        // 设置邮件的内容体
        message.setContent("验证码：" + emailCode, "text/html;charset=UTF-8");
        // 最后当然就是发送邮件啦
        Transport.send(message);
    }
}
