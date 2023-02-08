package com.Customer.UserLoginMoudle.PiplineValidate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * PROJECT_NAME RegistryPiepleContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:11
 */
@Getter
@Setter
@Component
public class PiepleContent implements Serializable {
    private LocalDateTime startDateTime; // 管道分支任务开始时间

    private LocalDateTime endDateTime; // 管道分支任务结束时间

    public String getName() {
        return this.getClass().getSimpleName();
    }

}
