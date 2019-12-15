package com.system.module2.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: dapeng_lgq
 * @since:JDK-1.8
 * @author: Star-GuoqingLi
 * @create: 2019-12-16 00:32
 * @version:第1版
 * @description:
 **/
@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AopLog implements Serializable {
    private String username; //用户
    private String operation; //操作
    private String method; //方法名
    private Date createDate; //操作时间
}
