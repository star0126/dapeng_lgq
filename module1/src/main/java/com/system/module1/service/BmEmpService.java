package com.system.module1.service;

import com.system.module1.entity.BmEmp;
import com.system.module1.util.EmpUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/11 11:21
 * @version: 1.0
 * @description:
 **/
public interface BmEmpService {

    //条件查找Emp
    List<BmEmp> findVlookupBmEmp(EmpUtil bmEmp);

}
