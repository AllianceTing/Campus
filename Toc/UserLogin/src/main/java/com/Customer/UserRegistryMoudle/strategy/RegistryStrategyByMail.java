package com.Customer.UserRegistryMoudle.strategy;

import com.Customer.UserRegistryMoudle.PiplineValidate.RegistryPipelineExcutor;
import com.Customer.UserRegistryMoudle.PiplineValidate.UserRegistryRequestContent;
import com.Customer.util.SendEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class RegistryStrategyByMail implements RegistryStrategy {
    @Resource
    RegistryPipelineExcutor pipelineExecutor;
    @Resource
    SendEmail sendEmail;

    @Override
    public boolean loginStrategy(UserRegistryRequestContent data) {
        // todo 接口复用性太低 需要升级 -- > USerRegistryByMail
        if (pipelineExecutor.acceptSync(data)) {
            //todo
            String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            try {
                sendEmail.sendEmail(data.getEmail(), emailCode);
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
    public RegistryTypeEnum getloginType() {
        return RegistryTypeEnum.MailRegistry;
    }
}
