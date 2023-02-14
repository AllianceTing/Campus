package com.compus.EnumStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * PROJECT_NAME SmsEnumStatus
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/13~18:34
 */
@ToString
@AllArgsConstructor
@Getter
public enum SmsEnumStatus {

    SEND_SUCCESS(10,"调用渠道接口发送成功"),

    RECEIVE_SUCCESS(20,"用户收到短信(收到渠道短信回执，状态成功)"),

    RECEIVE_FAIL(30,"用户收不到短信(收到渠道短信回执，状态失败)"),

    SEND_FAIL(40,"调用渠道接口发送失败");

    private Integer code;
    private String description;


    /**
     * 根据状态获取描述信息
     *
     * @param code
     * @return
     */
    public static String getDescriptionByStatus(Integer code) {
        for (SmsEnumStatus value : SmsEnumStatus.values()) {
            if (value.getCode().equals(code)) {
                return value.getDescription();
            }
        }
        return "";
    }
}
