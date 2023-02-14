package com.compus.Request;

import com.compus.domain.TaskInfo;
import lombok.Data;
import lombok.Getter;

/**
 * PROJECT_NAME TaskRequestVo
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/14~21:32
 */
@Data
@Getter
public class TaskRequestVo extends TaskInfo {

    private String UserId;
}
