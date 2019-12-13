package com.system.module1.service;

import com.system.module1.entity.BmTask;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 19:30
 * @version: 1.0
 * @description:
 **/
public interface BmTaskService {
    //分页动态检索task信息
    List<BmTask> findBmTask(BmTask bmTask, String sort, Integer pageIndex, Integer pageSize);

    //查询数据统计
    int fintCount(BmTask bmTask,String sort);

    //新增一条task的方法
    int addTask(BmTask bmTask);

    //根据编号查找一条task
    BmTask findBmTaskById(Integer taskId);

    //修改一条task的方法
    int updBmTask(BmTask bmTask);

    //批量删除的方法
    int delBatchTask(Integer [] ids);
}
