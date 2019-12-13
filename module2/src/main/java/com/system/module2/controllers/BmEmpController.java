package com.system.module2.controllers;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.module2.dao.BmEmpMapper;
import com.system.module2.entity.BmEmp;
import com.system.module2.mytemplate.ErrorMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-12-13
 */
@Api(tags = "emp控制器")
@Controller
@Slf4j
public class BmEmpController {

    @ApiOperation(value="跳转到登陆页面", notes="登录")
    @GetMapping(value = "/login")
    public String goLogin(){
        return "login";
    }
    
    @Autowired
    BmEmpMapper bmEmpMapper;


    @ApiOperation(value="登陆操作", notes="登录处理")
    @PostMapping(value = "/emp_login")
    public String login(BmEmp bmEmp){
        boolean ind = bmEmp==null || "".equals(bmEmp)?false:true;
        //登陆时没有收到用户名和密码！
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.LOGINPARAMETERNUL.getText());}
        ind = bmEmp.getEmpId()==null || "".equals(bmEmp.getEmpId())?false:ind;
        //登陆时没有收到用户名
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.NAMENUL.getText());}
        ind = bmEmp.getEmpPwd()==null || "".equals(bmEmp.getEmpPwd())?false:ind;
        //登陆时没有收到密码
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.PWDNUL.getText());}
        String str = "";
        BmEmp loginemp = bmEmpMapper.selectById(bmEmp.getEmpId());
        if (loginemp==null || "".equals(loginemp)){
            //进行全局异常处理
        }


        return str;
    }

}

