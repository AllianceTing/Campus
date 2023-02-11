package com.Customer.UserLoginMoudle.PiplineValidate;

import com.Customer.Exception.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;


/**
 * PROJECT_NAME RegistryPiepleContentDataPreChecker
 * 校验用户名和密码
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:25
 */
@Component
public class PiepleContentUserAPDataPreChecker implements Contenxthandler<UserLoginReuestContent> {

    //密码为八位及以上并且字母数字特殊字符三项都包括
    private static final Pattern strongPattern = Pattern.compile("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$");
    //密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等
    private static final Pattern middlePattern = Pattern.compile("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$");
    private static final Pattern enoughPattern = Pattern.compile("(?=.{6,}).*");

    /**
     * @param userVo - > RegistryPipileContent
     * @return Boolean ? else
     */
    @Override
    public boolean handle(UserLoginReuestContent userVo) {
        var userPassword = userVo.getUserPassword().trim();
        var userAccount = userVo.getUserPassword().trim();
        if (userVo == null || userPassword == null || userAccount == null) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.USER_REQUEST_NULL_ERROR));
        } else {
            if (true) {
                if (userPassword.length() >= 12 && userPassword.length() <= 18 && !userAccount.equals("")) {
                    return !strongPattern.matcher(userPassword).matches();
                }
                if (userPassword.length() >= 6 && userPassword.length() < 12 && !userAccount.equals("")) {
                    return !middlePattern.matcher(userPassword).matches();
                }
                if (userPassword.length() >= 1 && userPassword.length() < 6 && !userAccount.equals("")) {
                    return !enoughPattern.matcher(userPassword).matches();
                }
            }
        }
        //进入其他校验模式
        return true;
    }
}
