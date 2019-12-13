package com.system.module1.dao;

import com.system.module1.entity.BmEmp;
import com.system.module1.util.EmpUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/11 11:00
 * @version: 1.0
 * @description:
 **/
@Mapper
public interface BmEmpDao {

    //条件查找Emp
    List<BmEmp> findVlookupBmEmp(@Param("bmEmp") EmpUtil bmEmp);

}
