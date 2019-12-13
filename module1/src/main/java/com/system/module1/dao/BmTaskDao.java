package com.system.module1.dao;

import com.system.module1.entity.BmTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 18:37
 * @version: 1.0
 * @description:
 **/
@Mapper
public interface BmTaskDao {

    //分页动态检索task信息
    List<BmTask> findBmTask(@Param("bmTask") BmTask bmTask,
                            @Param("sort") String sort,
                            @Param("pageIndex") Integer pageIndex,
                            @Param("pageSize") Integer pageSize);

    //查询数据统计
    int fintCount(@Param("bmTask") BmTask  bmTask,@Param("sort") String sort);

    //新增一条task的方法
    int addTask(@Param("bmTask") BmTask bmTask);

    //根据编号查找一条task
    BmTask findBmTaskById(@Param("taskId") int taskId);

    //修改一条task的方法
    int updBmTask(@Param("bmTask") BmTask bmTask);

    //批量删除的方法
    int delBatchTask(@Param("ids")Integer [] ids);

}
