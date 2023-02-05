package com.Customer.Controller;


import com.Customer.Exception.ResultUtils;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.util.PasswordStrength;
import com.Customer.util.SendEmail;
import com.Customer.util.SendMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.concurrent.ThreadLocalRandom;

/**
 * PROJECT_NAME UserRegistry
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~22:28
 */
@RestController
@Validated
@RequestMapping(value = "/user")
public class UserRegistry {
    @Resource
    private UserService userService;
    @Resource
    private SendMessage sendMessage;
    @Resource
    private SendEmail sendEmail;

    /**
     * 校验手机号格式并且发送信息验证码。
     *
     * @param phoneNumber
     * @param req
     * @return
     */
    @PostMapping("/register")
    public Object registryUserByNumber(@RequestBody @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$"
            , message = "手机号格式有误") String phoneNumber, HttpServletRequest req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phoneNumber);
        User user = userService.getOne(queryWrapper);
        if (user != null) {
            return ResultUtils.error(50400, "登录失败，手机号已存在", user.getUserAccount());
        } else {
            //todo
            String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            HttpSession session = req.getSession(true);
            session.setAttribute("authCode", authCode);
            session.setMaxInactiveInterval(60 * 5);
            sendMessage.Send(phoneNumber, authCode);
            return ResultUtils.success("OK");
        }
    }

    /**
     * 校验信息验证码是否正确.
     *
     * @param phoneNumber
     * @param userAuthCode
     * @param authCode
     * @return
     */
    @PostMapping("/register/authcode")
    public Object verifyAuthCode(@RequestBody @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
                                 String phoneNumber, @RequestBody @RequestParam("authCode") @NotNull String userAuthCode,
                                 @SessionAttribute(value = "authCode", required = false) String authCode) {
        if (authCode == null) {
            // TODO Auto-generated method stub
            return ResultUtils.error(50400, "验证码已经失效", "");
        }
        if (!userAuthCode.equals(authCode)) {
            // todo  method
            return ResultUtils.error(50404, "验证码错误", "");
        }
        // STOPSHIP: 2023/2/2
        return ResultUtils.success("OK");

    }

    /**
     * 】
     * 判断账户是否已经使用
     *
     * @param userAccount
     * @return
     */
    @PostMapping("/register/username")
    public Object userAccount(@RequestBody @NotBlank String userAccount) {
        String account = userAccount.trim();
        if (account.length() > 18 || account.length() < 6) {
            ResultUtils.error(50400, "长度不合法", "");
        }
        User retUser = userService.selectUserByAccount(account);
        if (retUser != null) {
            return ResultUtils.error(50401, "该账号已经存在", retUser.getUserAccount());
        }
        return ResultUtils.success("OK");
    }

    /**
     * 校验密码强度
     *
     * @param password
     * @return
     */
    @PostMapping("/register/password")
    public Object password(@RequestBody @NotBlank String password) {
        String password1 = password.trim();
        if (password1.length() > 18 || password1.length() < 6) {
            ResultUtils.error(50400, "长度不合法", "");
        }
        int strength = PasswordStrength.checkStrength(password1);
        return ResultUtils.success(strength);
    }

    /**
     * 发送邮件验证码
     *
     * @param email
     * @param req
     * @return
     * @throws MessagingException
     */
    @PostMapping("/register/sendUserCode")
    public Object sendUserCode(@RequestBody @Email(message = "邮箱格式错误") String email, HttpServletRequest req) throws MessagingException {
        User retUser = userService.selectUserByEmail(email);
        if (retUser != null) {
            //如果已经使用邮箱返回账号
            return ResultUtils.error(50401, "", retUser.getUserAccount());
        }
        //todo
        String emailCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
        HttpSession session = req.getSession(true);
        session.setAttribute("emailCode", emailCode);
        session.setMaxInactiveInterval(60 * 5);
        sendEmail.sendEmail(email,emailCode);
        return ResultUtils.success("OK");
    }
}


