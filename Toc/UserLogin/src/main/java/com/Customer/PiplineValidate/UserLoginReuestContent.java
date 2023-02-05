package com.Customer.PiplineValidate;

import lombok.Getter;
import lombok.Setter;


/**
 * PROJECT_NAME UserLoginReuestContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:27
 */
@Getter
@Setter
public class UserLoginReuestContent extends PiepleContent {
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPassword;
    private String PhoneNumber;
    private String authCode;

    private String email;

    @Override
    public String getName() {
        return "Starting Building";
    }
}
