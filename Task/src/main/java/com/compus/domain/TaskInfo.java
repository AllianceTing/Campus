package com.compus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName(value = "Task_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TaskInfo implements Serializable {
    /**
     * 任务id
     */
    @TableId(value = "task_id")
    private String task_id;

    /**
     * 任务标题
     */
    @TableField(value = "title")
    private String task_title;

    /**
     * 0-- 未接受  1 ---  已接受 任务接受状态
     */
    @TableField(value = "task_accept_status")
    private Integer task_accept_status;

    /**
     * 任务创建时间
     */
    @TableField(value = "task_create_time")
    private Date task_create_time;

    /**
     * 任务删除时间
     */
    @TableField(value = "task_del_time")
    private Date task_del_time;

    /**
     * 任务单价
     */
    @TableField(value = "task_price")
    private Integer task_price;

    /**
     * 任务开始时间
     */
    @TableField(value = "task_start_time")
    private Date task_start_time;

    /**
     * 任务结束时间
     */
    @TableField(value = "task_end_time")
    private Date task_end_time;

    /**
     * 0 --未接受 1-- 已接受
     */
    @TableField(value = "task_status")
    private Integer task_status;

    /**
     * 任务接收人姓名
     */
    @TableField(value = "task_receive_name")
    private String task_receive_name;

    /**
     * 任务接收人id
     */
    @TableField(value = "task_receive_id")
    private String task_receive_id;

    @TableField(value = "task_push_id")
    private String task_push_id;
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 1L;

}
