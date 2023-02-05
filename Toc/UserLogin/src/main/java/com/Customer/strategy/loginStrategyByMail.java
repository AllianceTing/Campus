package com.Customer.strategy;

import com.Customer.Service.UserService;
import com.Customer.chains.UserLoginReuestContent;
import com.Customer.chains.pipelineExecutor;
import com.Customer.util.SendEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * PROJECT_NAME loginStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByMail implements loginStrategy {
    @Resource
    pipelineExecutor pipelineExecutor;
    @Resource
    UserService userService;
    @Resource
    SendEmail sendEmail;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        // todo 接口复用性太低 需要升级 -- > USerRegistryByMail
        if (pipelineExecutor.acceptSync(data)) {
            //todo
            String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            try {
                boolean flag = sendEmail.sendEmail(data.getEmail(), emailCode);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (emailCode == data.getEmail()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MailLogin;
    }
}
