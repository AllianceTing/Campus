package com.compus.Message;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * PROJECT_NAME doSendMessageService
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/12~11:52
 */
@Component
public class doSendMessageService {
    @Value("${message.AccessKeyId}")
    String AccessKeyId;
    @Value("${message.AccessSecret}")
    String AccessSecret;
    @Value("${message.SmsMessageTempId}")
    String SmsMessageTempId;
    @Value("${message.SmsMessageTempCode}")
    String SmsMessageTempCode;

    public boolean smsSendMessage(String Phone) throws Exception {
        int smsCode = (int) (Math.random() * 9 + 1000);
        com.aliyun.dysmsapi20170525.Client client = createClient(AccessKeyId, AccessSecret);
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(Phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SmsMessageTempId);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(SmsMessageTempCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":" + smsCode + "}");
        //hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = client.sendSms(request);
            Integer statusCode = sendSmsResponse.getStatusCode();
            System.out.println(statusCode);
            return true;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return false;
    }

    public static com.aliyun.dysmsapi20170525.Client createClient(final String accessKeyId, final String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret)
                // 访问的域名
                .setEndpoint("dysmsapi.aliyuncs.com")
                .setRegionId("cn-hangzhou");
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}

