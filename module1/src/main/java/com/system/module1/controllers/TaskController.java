package com.system.module1.controllers;

import com.system.module1.entity.BmTask;
import com.system.module1.service.BmTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 15:34
 * @version: 1.0
 * @description:
 **/
@Controller
public class TaskController {

    @Autowired
    private BmTaskService bmTaskService;

    //跳转到index.html页面
    @RequestMapping(value = "/task_list")
    public String findIndex(){
        return "index";
    }

    //跳转task_info.html页面
    @RequestMapping(value = "/task_info")
    public String findTaskInfo(){
        return "task_info";
    }

    //跳转到新增页面task_add.html
    @RequestMapping(value = "/task/add")
    public String addTask(){
        return "task_add";
    }

    //跳转到修改页面的方法
    @RequestMapping(value = "/upd/{taskId}")
    public String updTask(@PathVariable("taskId") Integer taskId,
                          Model model){
        BmTask bmTask = bmTaskService.findBmTaskById(taskId);
        model.addAttribute("tk",bmTask);
        return "task_upd";
    }

    //查找task列表的方法
    @RequestMapping(value = "/task/list",method = RequestMethod.POST)
    @ResponseBody
    public Object list( BmTask bmTask,BindingResult result,String sort,
                       @RequestParam(value = "pageIndex",required = true,defaultValue = "0")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = true,defaultValue = "5")Integer pageSize){
        Map<Object,Object> map = new HashMap<Object, Object>();
        bmTask = bmTask==null || "".equals(bmTask)?new BmTask():bmTask;
        sort = sort==null || "".equals(sort)?null:sort;
        List<BmTask> data = bmTaskService.findBmTask(bmTask,sort,pageIndex,pageSize);
        int total = bmTaskService.fintCount(bmTask,sort);
        map.put("total",total);
        map.put("data",data);
        return map;
    }

    //修改一条task的方法
    @RequestMapping(value = "/task/upd_task",method = RequestMethod.POST)
    @ResponseBody
    public int upd(@Validated BmTask bmTask, BindingResult result){
        if (bmTask==null || "".equals(bmTask)){
            throw  new  RuntimeException("修改task时传值错误，请检查！");
        }
        int sign = 0;
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ed = sd.format(bmTask.getEdtime());
            String bg = sd.format(bmTask.getBgtime());
            Date endTime = sd.parse(ed);
            Date creatTime = sd.parse(bg);
            bmTask.setEndTime(endTime)
                    .setCreatTime(creatTime);
            sign = bmTaskService.updBmTask(bmTask);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return sign;
        }
    }

    //新增一条task的方法
    @RequestMapping(value = "/task/add_task",method = RequestMethod.POST)
    @ResponseBody
    public int add(@Validated BmTask bmTask, BindingResult result)  {
        if (bmTask==null || "".equals(bmTask)){
            throw  new  RuntimeException("新增task时传值错误，请检查！");
        }
        int sign = 0;
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ed = sd.format(bmTask.getEdtime());
            Date parse = sd.parse(ed);
            bmTask.setEndTime(parse)
                    .setCreatTime(new Date());
            sign = bmTaskService.addTask(bmTask);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return sign;
        }

    }

    //批量删除的方法
    @RequestMapping(value = "/task/del",method = RequestMethod.POST)
    @ResponseBody
    public int del(Integer [] ids){
        if (ids==null || ids.length<=0){
            throw new RuntimeException("批量删除时传值错误，请检查！");
        }
        int sign = 0;
        sign = bmTaskService.delBatchTask(ids);
        return sign;
    }

}
