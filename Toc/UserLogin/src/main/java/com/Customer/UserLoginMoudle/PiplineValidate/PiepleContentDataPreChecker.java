package com.Customer.UserLoginMoudle.PiplineValidate;

import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import org.springframework.stereotype.Component;

/**
 * PROJECT_NAME RegistryPiepleContentDataPreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Component
public class PiepleContentDataPreChecker implements Contenxthandler<UserLoginReuestContent> {

    /**
     * @param userVo - > RegistryPiepleContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent userVo) {
        if (userVo == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        var userPassword = userVo.getUserPassword().trim();
        if (userPassword.length() >= 2 && userPassword.length() <= 18) {
            return true;
        } else {
            return false;
        }
    }
}
