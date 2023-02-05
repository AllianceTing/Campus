package com.Customer.UserRegistryMoudle.PiplineValidate;

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
public class UserRegistryRequestContent extends RegistryPiepleContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userAccount;
    private String userPassword;
    private String phoneNumber;
    private String authCode;
    private String email;

    @Override
    public String getName() {
        return "Starting Building Pipeline Validate" + this.getClass().getSimpleName();
    }
}
