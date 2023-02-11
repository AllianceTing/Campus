package com.Customer.Controller;

import com.Customer.Config.KaptchaConfig;
import com.Customer.Exception.BusinessException;
import com.Customer.Exception.ErrorCode;
import com.Customer.Exception.ResultUtils;
import com.Customer.PO.User;
import com.Customer.Service.UserService;
import com.Customer.UserLoginMoudle.PiplineValidate.UserLoginReuestContent;
import com.Customer.UserLoginMoudle.strategy.LoginTypeEnum;
import com.Customer.VO.UserVo;
import com.Customer.util.JWTUtils;
import com.Customer.util.SendMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
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
public class UserLogin {
    @Resource
    UserService userService;
    @Resource
    KaptchaConfig captchaProducer;
    @Resource
    SendMessage sendMessage;

    @PostMapping("/login")
    public Object userLogin(@RequestBody @NotBlank @Validated UserLoginReuestContent userVo, @RequestParam @NotBlank LoginTypeEnum strategyName, HttpServletResponse response) {
        Object doUserLogin = userService.doUserLogin(userVo, strategyName);
        String token = JWTUtils.CreateJWT(userVo.getUserAccount(), userVo.getUserPassword());
        Cookie cookie = new Cookie("AUTH", token);
        response.addCookie(cookie);
        return ResultUtils.success(doUserLogin);
    }

    @PostMapping("/logout")
    public Object userLogOut(@RequestBody @NotBlank @Validated UserLoginReuestContent userVo, HttpServletResponse response) {
        return userService.doUserLogOut(userVo);
    }

    @PostMapping("/loginGetMessageCode")
    public Object loginGetMessageCode(@RequestParam("phone") String phone, HttpServletRequest req) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("phone", phone);
        User one = userService.getOne(wrapper);
        System.out.println(one);
        if (one == null) {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
            //todo 请注册
        } else {
            //todo
            String authCode = String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
            HttpSession session = req.getSession(true);
            session.setAttribute("authCode", authCode);
            session.setAttribute("messagePhone", phone);
            session.setMaxInactiveInterval(60 * 5);
            sendMessage.Send(phone, authCode);
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
        QueryWrapper<User> UserBasequeryWrapper = new QueryWrapper<User>();
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
