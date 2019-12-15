package com.system.module2.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
public class BmEmp implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "emp_id", type = IdType.INPUT)
    private String empId;

    @TableField(value = "emp_pwd")
    private String empPwd;

    @TableField(value = "emp_name")
    private String empName;

    @TableField(value = "emp_sex")
    private String empSex;

    @TableField(value = "emp_dept")
    private Integer empDept;

    @TableField(value = "emp_role")
    private String empRole;

    @TableField(value = "emp_status")
    private String empStatus;

    @TableField(value = "emp_email")
    private String empEmail;

    @TableField(value = "emp_phone")
    private String empPhone;

    @TableField(value = "jur_ide")
    private Integer jurIde;


}
