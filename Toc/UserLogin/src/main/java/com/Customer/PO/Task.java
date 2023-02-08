package com.Customer.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-06
 * Time:20:37
 *
 * @Author: 东莞呵呵
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName(value = "Task_info")
public class Task {
    /**
     *
     */
    @TableField(value = "task_id")
    @TableId
    private Long taskId;

    /**
     *
     */
    @TableField(value = "title")
    private String title;

    /**
     *
     */
    @TableField(value = "task_accept_status")
    private int taskAcceptStatus;

    /**
     *
     */
    @TableField(value = "task_create_time")
    private String taskCreateTime;

    /**
     *
     */
    @TableField(value = "task_del_time")
    private String taskDelTime;

    /**
     *
     */
    @TableField(value = "task_price")
    private double taskPrice;

    /**
     *
     */
    @TableField(value = "task_start_time")
    private String taskStartTime;

    /**
     *
     */
    @TableField(value = "task_end_time")
    private String taskEndTime;

    /**
     *
     */
    @TableLogic
    @TableField(value = "task_status")
    private int taskStatus;

    /**
     *
     */
    @TableField(value = "task_receive_name")
    private int taskReceiveName;

    /**
     *
     */
    @TableField(value = "task_receive_id")
    private int taskReceiveId;
}
