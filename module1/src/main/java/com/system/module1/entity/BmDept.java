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
 * @create: 2019/12/10 16:27
 * @version: 1.0
 * @description:
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //连式编程
public class BmDept implements Serializable {

    private Integer deptId; //编号
    private String deptName; //部门名称
    private Integer parentId; //上级部门编号
}
