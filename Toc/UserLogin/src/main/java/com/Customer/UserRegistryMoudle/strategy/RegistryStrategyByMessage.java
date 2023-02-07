package com.Customer.UserRegistryMoudle.strategy;


import com.Customer.UserRegistryMoudle.PiplineValidate.RegistryPipelineExcutor;
import com.Customer.UserRegistryMoudle.PiplineValidate.UserRegistryRequestContent;
import com.Customer.util.SendMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ThreadLocalRandom;

/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class RegistryStrategyByMessage implements RegistryStrategy {

    @Resource
    RegistryPipelineExcutor pipelineExecutor;
    @Resource
    SendMessage sendMessage;

    @Override
    public boolean loginStrategy(UserRegistryRequestContent data) {
        if (pipelineExecutor.acceptSync(data)) {
            ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert ra != null;
            HttpServletRequest req = ra.getRequest();
            String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            HttpSession session = req.getSession(true);
            session.setAttribute("authCode", authCode);
            session.setMaxInactiveInterval(60 * 5);
            sendMessage.Send(data.getPhoneNumber(), authCode);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (session.getAttribute("authCode").equals(data.getAuthCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public RegistryTypeEnum getloginType() {
        return RegistryTypeEnum.MessageRegistry;
    }
}
