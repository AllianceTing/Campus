package com.Customer.Service.impl;

import com.Customer.Mapper.TaskMapper;
import com.Customer.Mapper.UserMapper;
import com.Customer.PO.Task;
import com.Customer.PO.User;
import com.Customer.Service.TaskService;
import com.Customer.Service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-06
 * Time:21:22
 *
 * @Author: 东莞呵呵
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Override
    public List<Task> selectALLTask(int pageNum, int pageSize) {
        Page<Task> taskPage=new Page<>(pageNum,pageSize);
        taskMapper.selectPage(taskPage,null);
        return taskPage.getRecords();
    }
}
