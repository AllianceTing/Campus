package com.compus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.compus.domain.TaskInfo;
import com.compus.mapper.TaskInfoMapper;
import com.compus.service.TaskService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @description 针对表【Task_info】的数据库操作Service实现
 * @createDate 2023-02-13 22:16:33
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskInfoMapper, TaskInfo>
        implements TaskService {

}




