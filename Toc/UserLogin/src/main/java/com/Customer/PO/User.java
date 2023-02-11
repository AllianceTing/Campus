package com.Customer.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * PROJECT_NAME Customer
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName(value = "user")
public class User implements Serializable {
    @TableField(value = "user_name")
    private String username;

    /**
     *
     */
    @TableField(value = "id")
    @TableId
    private Long id;

    /**
     *
     */
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
    @TableField(value = "user_password")
    private String userPassword;

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

    /**
     *
     */
    @TableField(value = "user_status")
    private Integer userStatus;

    /**
     *
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     *
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     *
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     *
     */
    @TableField(value = "user_role")
    private Integer userRole;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
