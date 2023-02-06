package com.Customer.Service;

import com.Customer.PO.Task;
import com.Customer.PO.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-02-06
 * Time:21:21
 *
 * @Author: 东莞呵呵
 */
@Service
public interface TaskService extends IService<Task> {
    List<Task> selectALLTask(int pageNum, int pageSize);

}
