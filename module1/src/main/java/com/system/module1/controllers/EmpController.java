package com.system.module1.controllers;

import com.system.module1.entity.BmEmp;
import com.system.module1.service.BmEmpService;
import com.system.module1.util.EmpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/11 10:51
 * @version: 1.0
 * @description:
 **/
@RestController
public class EmpController {

    @Autowired
    private BmEmpService bmEmpService;

    //异步条件获取Emp
    @RequestMapping(value = "/emp/lookup/list")
    public Object list(EmpUtil empUtil){
        empUtil= empUtil==null || "".equals(empUtil)?null:new EmpUtil();
        List<BmEmp> bmEmpList = bmEmpService.findVlookupBmEmp(empUtil);
        return bmEmpList;
    }

}
