package com.system.module1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/10 16:18
 * @version: 1.0
 * @description:
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //连式编程
public class BmTask implements Serializable {

    private Integer taskId;  //编号
    @NotBlank(message = "任务名不能为空")
    private String taskName; //任务名
    @NotBlank(message = "任务类型不能为空")
    private String taskType; //任务类型
    @NotBlank(message = "任务创建者不能为空")
    private String taskCreator; //任务创建者编号
    private String creatorName; //创建者姓名
    @NotNull(message = "创建时间不能为空")
    private Integer creatorDept; //创建者部门
    private String deptName; //创建者部门名称
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "创建时间不能为空")
    private Date creatTime; //任务创建时间
   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private Date endTime; //任务结束时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planStartTime; //任务计划开始时间
   @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planEndTime; //任务计划结束时间
    @NotBlank(message = "任务执行者不能为空")
    private String taskExecutor; //任务执行者编号
    private String executor; //任务执行者姓名
    @NotBlank(message = "任务状态不能为空")
    private String taskStatus; //任务状态
    private String taskSpec; //任务说明


    private Long bgtime;  //开始时间
    private Long edtime;  //截至时间
    private String sort; //排序字段


}