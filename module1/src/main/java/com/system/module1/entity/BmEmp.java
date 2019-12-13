package com.system.module1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 16:29
 * @version: 1.0
 * @description:
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //连式编程
public class BmEmp implements Serializable {

    private String empId; //编号
    private String empPwd; //密码
    private String empName; //姓名
    private String empSex; //性别
    private Integer empDept; //部门
    private String deptName; //部门名
    private String empRole; //职位
    private String empStatus; //状态
    private String empEmail; //邮箱
    private String empPhone; //电话
    private Integer jurIde; //权限标识
}