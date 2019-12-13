package com.system.module2.mytemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/13 17:12
 * @version: 1.0
 * @description:
 **/
@Builder
@Data
@AllArgsConstructor
public class ApiResponse {

    private Object message;

    private Integer code;

}
