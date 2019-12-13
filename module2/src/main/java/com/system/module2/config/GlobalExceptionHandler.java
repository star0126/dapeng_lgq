package com.system.module2.config;

import com.system.module2.mytemplate.ApiResponse;
import com.system.module2.mytemplate.ErrorResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: dapeng_lgq
 * @since: JDK-1.8
 * @author: dapeng-liguoqing
 * @create: 2019/12/13 16:13
 * @version: 1.0
 * @description: 全局异常处理
 **/
@ControllerAdvice(basePackages = {"com.system.module2",})//定义统一的异常处理类
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    /**
     * 处理不合法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    /*@ResponseBody
    ResponseEntity handleConflictException(IllegalArgumentException e) {
        ApiResponse apiResponse = ApiResponse.builder().code(HttpStatus.CONFLICT.value()).message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }*/
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.CONFLICT.value());
        IllegalArgumentException exception = (IllegalArgumentException) e;
        return new ErrorResponseEntity(409, exception.getMessage());
    }


    /**
     * 通用的接口映射异常处理方
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(
                    new ErrorResponseEntity(status.value(),
                                            exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                                            status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
        }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
    }

}
