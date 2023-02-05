package com.Customer.UserRegistryMoudle.PiplineValidate;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * PROJECT_NAME RegistryPiepleContent
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/2~10:11
 */
@Getter
@Setter
public class RegistryPiepleContent {
    private LocalDateTime startDateTime; // 管道分支任务开始时间

    private LocalDateTime endDateTime; // 管道分支任务结束时间

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
