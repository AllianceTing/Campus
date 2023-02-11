package com.Customer.UserLoginMoudle.PiplineValidate;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * PROJECT_NAME RegistryPipileContentDataPreChecker
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Component
public class PiepleContentPhoneDataPreChecker implements Contenxthandler<UserLoginReuestContent> {
    private static final Pattern pattern = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");

    /**
     * @param userVo - > RegistryPipileContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent userVo) {
        var PhoneNumber = userVo.getPhoneNumber().trim();
        var AuthCode = userVo.getAuthCode().trim();
        if (PhoneNumber != null && AuthCode != null) return true;
        if (userVo.getUserAccount() == null && userVo.getUserPassword() == null) {
            return true;
        }
        if (PhoneNumber.length() == 11) {
            if (!pattern.matcher(PhoneNumber).matches()) return false;
            return true;
        }
        if (AuthCode.length() == 6) {
            return true;
        } else {
            return false;
        }
    }
}
