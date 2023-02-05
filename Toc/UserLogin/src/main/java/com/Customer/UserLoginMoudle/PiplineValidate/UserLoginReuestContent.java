package com.Customer.UserLoginMoudle.PiplineValidate;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * PROJECT_NAME UserRegistryRequestContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:27
 */
@Getter
@Setter
public class UserLoginReuestContent extends PiepleContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPassword;
    private String PhoneNumber;
    private String authCode;
    private String email;
    private String emailCode;


    @Override
    public String getName() {
        return "Starting Building Pipeline Validate" + this.getClass().getSimpleName();
    }
}
