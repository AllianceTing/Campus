package com.Customer.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * PROJECT_NAME JWTUtils
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/8~21:31
 */
@Component
public class JWTUtils {
    public static String CreateJWT(String UserID, String Password) {
        return JWT.create().withAudience(UserID).withExpiresAt(DateUtil.offsetHour(new Date(), 5))
                .sign(Algorithm.HMAC256(Password));
    }

}
