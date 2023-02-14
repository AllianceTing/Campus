package com.compus.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.compus.Exception.BaseResponse;
import com.compus.Exception.BusinessException;
import com.compus.Exception.ErrorCode;
import com.compus.Exception.ResultUtils;
import com.compus.Request.TaskRequestVo;
import com.compus.domain.TaskInfo;
import com.compus.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /*
        查看发布的任务 未登录用户只能查看10条记录
     */
    @PostMapping("/searchTaskList")
    public IPage<TaskInfo> doSearchTaskList(@RequestParam(required = false, defaultValue = "1") Integer pageSize, @RequestParam(required = false, defaultValue = "8") Integer pageNum, @RequestBody(required = false) TaskInfo taskInfo, @RequestParam(required = false) @Size(min = 1, max = 2, message = "error price interval") BigDecimal[] bePrice) {
        //todo 未登录的用户只能查看部分数据
        QueryWrapper<TaskInfo> taskInfoLambdaQueryWrapper = new QueryWrapper<>();
        if (false) {
            return taskService.page(new Page<>(1, 10), taskInfoLambdaQueryWrapper);
        }
        taskInfoLambdaQueryWrapper.like(taskInfo.getTask_title() != null, "title", taskInfo.getTask_title());
        taskInfoLambdaQueryWrapper.ne(taskInfo.getTask_accept_status() != null, "task_accept_status", taskInfo.getTask_accept_status());
        //todo 优化成消费形函数式表达式
        taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_create_time().before(taskInfo.getTask_end_time()) && taskInfo.getTask_status() == 1 && taskInfo.getTask_start_time() != null, "task_accept_status", taskInfo.getTask_accept_status());
        taskInfoLambdaQueryWrapper.between(Arrays.stream(bePrice).findAny().isPresent(), "task_price", bePrice[0], bePrice[1]);
        taskInfoLambdaQueryWrapper.eq(taskInfo.getTask_price() != null, "task_price", taskInfo.getTask_price());
        Page<TaskInfo> page = taskService.page(new Page<>(pageSize, pageNum), taskInfoLambdaQueryWrapper);
        return (IPage<TaskInfo>) ResultUtils.success(page);

    }

    /*
   发布和修改任务一个
     */
    @PostMapping("/pushTask")
    public BaseResponse doPushTask(@RequestBody TaskInfo taskInfo) {
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
            return ResultUtils.error(ErrorCode.DELETE_ERROR);
        }
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    /*
    下架任务
     */
    @PostMapping("/pullTask")
    public BaseResponse doPullTask(@RequestBody TaskInfo taskInfo) {
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
            return ResultUtils.error(ErrorCode.DELETE_ERROR);
        }
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    /*
    用户接受任务
     */
    @PostMapping("/receiveTask")
    public BaseResponse<ErrorCode> doReceiveTask(@RequestBody TaskRequestVo taskRequestVo) {
        if (taskRequestVo.getUserId() != null && taskRequestVo.getTask_id() != null) {
            TaskInfo byId = taskService.getById(taskRequestVo.getTask_id());
            if (byId != null) {
                synchronized (taskRequestVo.getTask_id()) {
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.setTask_id(taskRequestVo.getTask_id());
                    taskInfo.setTask_price(taskRequestVo.getTask_price());
                    taskInfo.setTask_receive_id(taskRequestVo.getUserId());
                    taskInfo.setTask_accept_status(1);
                    boolean b = taskService.saveOrUpdate(taskInfo);
                    if (b) {
                        return ResultUtils.success(ErrorCode.SUCCESS);
                    }
                    return ResultUtils.error(ErrorCode.SYSTEM_ERROR);
                }
            }
        }
        throw new BusinessException(ErrorCode.NULL_ERROR);
    }

    /*
    用户取消任务
     */
    @PostMapping("/quitTask")
    public BaseResponse<ErrorCode> doQuitTask(@RequestBody TaskRequestVo taskRequestVo) {
        if (taskRequestVo.getUserId() != null && taskRequestVo.getTask_id() != null) {
            TaskInfo byId = taskService.getById(taskRequestVo.getTask_id());
            if (byId != null) {
                synchronized (taskRequestVo.getTask_id()) {
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.setTask_receive_id(null);
                    taskInfo.setTask_accept_status(0);
                    boolean b = taskService.updateById(taskInfo);
                    if (b) {
                        return ResultUtils.success(ErrorCode.SUCCESS);
                    }
                    return ResultUtils.error(ErrorCode.SYSTEM_ERROR);
                }
            }
        }
        throw new BusinessException(ErrorCode.NULL_ERROR);
    }
}
