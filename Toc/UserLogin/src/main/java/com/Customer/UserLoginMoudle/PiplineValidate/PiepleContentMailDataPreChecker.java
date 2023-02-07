package com.Customer.UserLoginMoudle.PiplineValidate;

import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * PROJECT_NAME RegistryPipileContentDataPreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Component
public class PiepleContentMailDataPreChecker implements Contenxthandler<UserLoginReuestContent> {
    private static final Pattern pattern = Pattern.compile("/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$/");

    /**
     * @param userVo - > RegistryPipileContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent userVo) {
        if (userVo == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        var Email = userVo.getEmail().trim();
        var EmailCode = userVo.getEmailCode().trim();
        if (userVo.getUserAccount() == null && userVo.getUserPassword() == null) {
            return true;
        }
        if (Email.length() == 15) {
            if (!pattern.matcher(EmailCode).matches()) return false;
            return true;
        }
        if (EmailCode.length() == 6) {
            return true;
        } else {
            return false;
        }
    }
}
