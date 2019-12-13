package com.system.module2.controllers;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="BmEmp对象", description="")
public class BmEmpDto implements Serializable {

    private static final long serialVersionUID=1L;


    private String empId;

    private String empPwd;

    @TableField("emp_name")
    private String empName;

    @TableField("emp_sex")
    private String empSex;

    @TableField("emp_dept")
    private Integer empDept;

    @TableField("emp_role")
    private String empRole;

    @TableField("emp_status")
    private String empStatus;

    @TableField("emp_email")
    private String empEmail;

    @TableField("emp_phone")
    private String empPhone;

    @TableField("jur_ide")
    private Integer jurIde;


}
