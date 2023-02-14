package com.Customer.util;

import cn.hutool.core.util.StrUtil;
import com.Customer.PO.User;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.compus.Exception.BusinessException;
import com.compus.Exception.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PROJECT_NAME JWT
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/8~21:57
 */
@Component
public class JWT implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getCookies()[0].toString();
        if (token == null && token.length() < 0) {
            throw new IllegalArgumentException("Cookies cannot be empty");
        }
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getBean().getClass().getName().equals("springfox.documentation.swagger.web.ApiResourceController")) {
            return true;
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new BusinessException(ErrorCode.NO_AUTH, "无token，请重新登录");
        }
        User user = null;
        String userID = com.auth0.jwt.JWT.decode(token).getAudience().get(0);
        try {
            // 用户密码加签验证 token
            JWTVerifier jwtVerifier = com.auth0.jwt.JWT.require(Algorithm.HMAC256(user.getUserPassword())).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new BusinessException(ErrorCode.AUTH_ERROR, "token验证失败");
        }
        return true;
    }
}

