package com.system.module1.service.impl;

import com.system.module1.dao.BmTaskDao;
import com.system.module1.entity.BmTask;
import com.system.module1.service.BmTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 19:32
 * @version: 1.0
 * @description:
 **/
@Service
public class BmTaskServiceImpl implements BmTaskService {

    @Resource
    private BmTaskDao bmTaskDao;

    //分页动态检索task信息
    @Override
    public List<BmTask> findBmTask(BmTask bmTask, String sort, Integer pageIndex, Integer pageSize) {
        return bmTaskDao.findBmTask(bmTask,sort,pageIndex,pageSize);
    }

    //查询数据统计
    @Override
    public int fintCount(BmTask bmTask,String sort) {
        return bmTaskDao.fintCount(bmTask,sort);
    }

    //新增一条task的方法
    @Override
    @Transactional
    public int addTask(BmTask bmTask) {
        return bmTaskDao.addTask(bmTask);
    }

    //根据编号查找一条task
    @Override
    public BmTask findBmTaskById(Integer taskId) {
        return bmTaskDao.findBmTaskById(taskId);
    }

    //修改一条task的方法
    @Override
    @Transactional
    public int updBmTask(BmTask bmTask) {
        return bmTaskDao.updBmTask(bmTask);
    }

    //批量删除的方法
    @Override
    @Transactional
    public int delBatchTask(Integer[] ids) {
        return bmTaskDao.delBatchTask(ids);
    }
}
