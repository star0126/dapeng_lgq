package com.system.module1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/11 11:34
 * @version: 1.0
 * @description: vlookupEmp的工具类
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //连式编程
public class EmpUtil  implements Serializable {

    private String empSex; //性别
    private List<Integer> empDept; //部门
    private List<String> empRole; //职位
    private List<String> empStatus; //状态
    private List<Integer> jurIde; //权限标识;

}
