package com.Customer.VO;

import com.Customer.UserLoginMoudle.PiplineValidate.PiepleContent;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.common.value.qual.MinLen;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * PROJECT_NAME UserVo
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~16:29
 */
@Getter
@Setter
public class UserVo extends PiepleContent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @MinLen(2)
    @Max(18)
    @TableField("user_account")
    private String userAccount;
    @MinLen(2)
    @Max(18)
    @TableField("user_password")
    private String userPassword;


}
