package com.Customer.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * PROJECT_NAME kaotchaUtils
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/5~20:51
 */

public class kaotchaUtils {
    @Resource
    private DefaultKaptcha producer;

    //生成catchCreator的map
    public String captchaCodeCreator() throws IOException {
        //生成文字验证码
        String text = producer.createText();
        return text;
    }
}
