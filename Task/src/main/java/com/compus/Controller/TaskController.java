package com.compus.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.compus.domain.TaskInfo;
import com.compus.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Arrays;

@RestController

/*
 * PROJECT_NAME TaskController
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/13~22:22.
 **/ public class TaskController {
    @Resource
    TaskService taskService;

    @GetMapping("/searchTaskList")
    public IPage<TaskInfo> doSearchTaskList(@RequestParam(required = false, defaultValue = "1") Integer pageSize, @RequestParam(required = false, defaultValue = "8") Integer pageNum, @RequestParam(required = false) TaskInfo taskInfo, @RequestParam(required = false) @Size(min = 1, max = 2, message = "error price interval") BigDecimal[] bePrice) {
        //todo 未登录的用户只能查看部分数据
        QueryWrapper<TaskInfo> taskInfoLambdaQueryWrapper = new QueryWrapper<>();
        taskInfoLambdaQueryWrapper.like(taskInfo.getTask_title() != null, "title", taskInfo.getTask_title());
        taskInfoLambdaQueryWrapper.ne(taskInfo.getTask_accept_status() != null, "task_accept_status", taskInfo.getTask_accept_status());
        //todo 优化成消费形函数式表达式
        taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_create_time().before(taskInfo.getTask_end_time()) && taskInfo.getTask_status() == 1 && taskInfo.getTask_start_time() != null, "task_accept_status", taskInfo.getTask_accept_status());
        taskInfoLambdaQueryWrapper.between(Arrays.stream(bePrice).findAny().isPresent(), "task_price", bePrice[0], bePrice[1]);
        taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_price() != null, "task_price", taskInfo.getTask_price());
        return taskService.page(new Page<>(pageSize, pageNum), taskInfoLambdaQueryWrapper);

    }

    /*
   发布和修改任务 一个
     */
    @GetMapping("/pushTask")
    public HttpStatus doPushTask(@RequestParam TaskInfo taskInfo) {
        //todo 必须校验用户的登录状态
        QueryWrapper<TaskInfo> taskInfoLambdaQueryWrapper = new QueryWrapper<>();
        QueryWrapper<TaskInfo> taskId = taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_id() != null, "task_id", taskInfo.getTask_id());
        if (taskId != null) {
            throw new IllegalStateException("任务已经被发布");
        }
        boolean b;
        synchronized (taskId) {
            b = taskService.saveOrUpdate(taskInfo);
        }
        if (b) {
            return HttpStatus.OK;
        }
        return HttpStatus.CONFLICT;
    }

    /*
    下架任务
     */
    @GetMapping("/pullTask")
    public HttpStatus doPullTask(@RequestParam TaskInfo taskInfo) {
        //todo 必须校验用户的登录状态
        QueryWrapper<TaskInfo> taskInfoLambdaQueryWrapper = new QueryWrapper<>();
        QueryWrapper<TaskInfo> taskId = taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_id() != null, "task_id", taskInfo.getTask_id());
        if (taskId == null) {
            throw new IllegalStateException("任务已经被下架");
        }
        boolean b;
        synchronized (taskId) {
            b = taskService.removeById(taskInfo.getTask_id());
        }
        if (b) {
            return HttpStatus.OK;
        }
        return HttpStatus.CONFLICT;
    }

}
