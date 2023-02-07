package com.Customer.UserLoginMoudle.strategy;

import com.Customer.UserLoginMoudle.PiplineValidate.PipelineExcutor;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * PROJECT_NAME RegistryStrategyByWeChat
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~12:01
 */
@Service
public class loginStrategyByMessage implements loginStrategy {

    @Resource
    PipelineExcutor pipelineExecutor;

    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        // todo 没有对messageCode 和PhoneCode 做规则性校验
        if (pipelineExecutor.acceptSync(data)) {
            ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert ra != null;
            HttpServletRequest req = (HttpServletRequest) ra.getRequest().getSession();
            Object messageCode = req.getAttribute("authCode");
            Object messagePhone = req.getAttribute("messagePhone");
            if (messageCode != null && messageCode.equals(data.getAuthCode()) && messagePhone.equals(data.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LoginTypeEnum getloginType() {
        return LoginTypeEnum.MessageLogin;
    }
}
