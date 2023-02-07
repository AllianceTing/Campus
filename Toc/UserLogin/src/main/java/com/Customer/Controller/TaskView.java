package com.Customer.Controller;

import com.Customer.PO.Task;
import com.Customer.Service.TaskService;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-06
 * Time:20:24
 *
 * @Author: 东莞呵呵
 */
@RequestMapping("/task")
@RestController
@Validated
public class TaskView {

    @Resource
    private TaskService taskService;

//    @RequestMapping("/info")
//    public Object viewTask(@NotNull Integer pageNum, @NotNull Integer pageSize, @CookieValue()){
//
//
//
//    }
}
