package com.Customer.UserLoginMoudle.PiplineValidate;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(value = "user_password")
    private String userPassword;
    private String phoneNumber;
    @TableField(value = "auth_code")
    private String authCode;
    private String emailCode;


    @TableField(value = "user_account")
    private String userAccount;

    /**
     *
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     *
     */
    @TableField(value = "gender")
    private Integer gender;


    /**
     *
     */
    @TableField(value = "phone")
    private String phone;

    /**
     *
     */
    @TableField(value = "email")
    private String email;

    @Override
    public String getName() {
        return "Starting Building Pipeline Validate" + this.getClass().getSimpleName();
    }
}
