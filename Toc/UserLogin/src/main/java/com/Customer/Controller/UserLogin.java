package com.Customer.Controller;

import com.Customer.Aop.PhoneCheck;
import com.Customer.Config.KaptchaConfig;
import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import com.Customer.Exception.ResultUtils;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.Customer.VO.UserVo;
import com.Customer.util.SendMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


/**
 * PROJECT_NAME UserLogin
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/29~16:26
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserLogin {
    @Resource
    UserService userService;
    @Resource
    KaptchaConfig captchaProducer;

    @PostMapping("/login")
    public Object userLogin(@RequestBody @NotBlank @Validated UserLoginReuestContent userVo, @RequestParam @NotBlank LoginTypeEnum strategyName) {
        return userService.doUserLogin(userVo, strategyName);
    }

    @PostMapping("/loginGetMessageCode")
    @PhoneCheck
    public Object loginGetMessageCode(String phoneNumber, HttpServletRequest req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phoneNumber);
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            return ResultUtils.error(50400, "登录失败，手机号未注册", user.getUserAccount());
        } else {
            //todo
            String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            HttpSession session = req.getSession(true);
            session.setAttribute("authCode", authCode);
            session.setAttribute("messagePhone", phoneNumber);
            session.setMaxInactiveInterval(60 * 5);
            SendMessage.Send(phoneNumber, authCode);
            return ResultUtils.success("OK");
        }
    }

    @PostMapping("/loginGetMailCode")
    public void loginGetMailCode(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest, UserLoginReuestContent userLoginReuestContent) throws IOException {

        if (userLoginReuestContent.getEmail() != null) {
            byte[] captchaOutputStream = null;
            ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
            try {
                //生产验证码字符串并保存到session中
                String verifyCode = captchaProducer.producer().createText();
                httpServletRequest.getSession().setAttribute("verifyCode", verifyCode);
                httpServletRequest.getSession().setAttribute("verifyEmail", userLoginReuestContent.getEmail());
                BufferedImage challenge = captchaProducer.producer().createImage(verifyCode);
                ImageIO.write(challenge, "jpg", imgOutputStream);
            } catch (IllegalArgumentException e) {
                httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            captchaOutputStream = imgOutputStream.toByteArray();
            httpServletResponse.setHeader("Cache-Control", "no-store");
            httpServletResponse.setHeader("Pragma", "no-cache");
            httpServletResponse.setDateHeader("Expires", 0);
            httpServletResponse.setContentType("image/jpeg");
            ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaOutputStream);
            responseOutputStream.flush();
            responseOutputStream.close();
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
        } //todo UserVo performance too low
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
