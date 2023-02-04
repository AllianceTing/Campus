package com.Customer.strategy;

import com.Customer.Exception.BusinessException;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.chains.UserLoginReuestContent;
import com.Customer.chains.pipelineExecutor;
import com.Customer.util.SendEmail;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @SneakyThrows
    @Override
    public boolean loginStrategy(UserLoginReuestContent data) {
        // todo 接口复用性太低 需要升级 -- > USerRegistryByMail
        if (pipelineExecutor.acceptSync(data)) {
            User retUser = userService.selectUserByEmail(data.getEmail());
            if (retUser != null) {
                //如果已经使用邮箱返回账号
                throw new BusinessException("account is already used by  user", 50400, "Invalid email");
            }
            //todo
            String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            SendEmail.sendEmail(data.getEmail(), emailCode);
            Thread.sleep(100);
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
