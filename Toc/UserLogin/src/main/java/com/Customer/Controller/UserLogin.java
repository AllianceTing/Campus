package com.Customer.Controller;

import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import com.Customer.Exception.ResultUtils;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.VO.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * PROJECT_NAME UserLogin
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~16:26
 */
@RestController
@RequestMapping(value = "/user")
public class UserLogin {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public Object userLogin(@RequestBody @NotBlank UserVo userVo) {
        //请求体不为空
        if (userVo == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        var userPassword = userVo.getUserPassword().trim();
        if (userPassword.length() >= 2 && userPassword.length() <= 18) {
            QueryWrapper<User> UserBasequeryWrapper = new QueryWrapper();
            UserBasequeryWrapper.eq("userAccount", userVo.getUserAccount());
            UserBasequeryWrapper.eq("userPassword", userVo.getUserPassword());
            return userService.getOne(UserBasequeryWrapper) == null ? ResultUtils.error(ErrorCode.AUTH_ERROR) : ResultUtils.success(ErrorCode.SUCCESS);
        } else {
            return ResultUtils.error(ErrorCode.AUTH_ERROR);
        }
    }

    @PostMapping("/registry")
    public Object userRegistry(@RequestBody @NotBlank @NotEmpty UserVo userVo) {
        if (userVo == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        QueryWrapper<User> UserBasequeryWrapper = new QueryWrapper();
        UserBasequeryWrapper.eq("userAccount", userVo.getUserAccount());
        UserBasequeryWrapper.eq("userPassword", userVo.getUserPassword());
        User userServiceOne = userService.getOne(UserBasequeryWrapper);
        if (userServiceOne != null) {
            return ResultUtils.error(ErrorCode.REPEAT_ERROR);
        }//todo UserVo performance too low
        boolean userSave;
        synchronized (userVo.getUserAccount()) {
            User user = new User();
            user.setUserAccount(userVo.getUserAccount());
            user.setUserAccount(userVo.getUserAccount());
            userSave = userService.save(user);
        }
        return userSave ? ResultUtils.success("添加用户信息成功") : ResultUtils.error(ErrorCode.SYSTEM_ERROR);
    }

}
