```sql
create table Task_info
(
    task_id            varchar(255) not null primary key unique comment '任务id',
    title              varchar(50)  not null comment '任务标题',
    task_accept_status tinyint(1)   not null default 0 comment '0-- 未接受  1 ---  已接受 任务接受状态',
    task_create_time   DateTime     Null     default current_timestamp comment '任务创建时间',
    task_del_time      DateTime     Null     default current_timestamp comment '任务删除时间',
    task_price         decimal      null comment '任务单价',
    task_start_time    DateTime     Null comment '任务开始时间' on update current_timestamp,
    task_end_time      DateTime     Null comment '任务结束时间' on update current_timestamp,
    task_status        tinyint(1)            default 0 not null comment '0 --未接受 1-- 已接受',
    task_receive_name  varchar(20)  Null comment '任务接收人姓名',
    task_receive_id    varchar(255) Null comment '任务接收人id'
) engine = Innodb;
```
