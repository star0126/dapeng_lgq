package com.system.module2.controllers;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.module2.aop.MyAop;
import com.system.module2.dao.BmDeptMapper;
import com.system.module2.dao.BmEmpMapper;
import com.system.module2.entity.BmDept;
import com.system.module2.entity.BmEmp;
import com.system.module2.mytemplate.ErrorMessage;
import com.system.module2.mytemplate.GeneralException;
import com.system.module2.mytemplate.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    //页面跳转请求
    @ApiOperation(value="跳转到登陆页面", notes="登录")
    @GetMapping(value = "/login")
    public String goLogin(){
        return "login";
    }

    @ApiOperation(value="登陆成功转向首页", notes="首页")
    @GetMapping(value = "/index")
    public String goIndex(){
        return "index";
    }

    @ApiOperation(value="内联框架展示用户详情", notes="用户详情")
    @GetMapping(value = "/sys/emp_info")
    public String goEmpInfo(){
        return "emp_info";
    }

    @ApiOperation(value="内联框架修改用户信息", notes="修改用户信息")
    @GetMapping(value = "/sys/upd_emp")
    public String goUpdEmp(){
        return "upd_emp";
    }

    @ApiOperation(value="内联框架修改用户密码", notes="修改密码")
    @GetMapping(value = "/sys/upd_pwd")
    public String goUpdPwd(){
        return "upd_pwd";
    }




    @Resource
    private BmEmpMapper bmEmpMapper;
    @Resource
    private BmDeptMapper bmDeptMapper;



    @MyAop(value = "用户登录")
    @ApiOperation(value="登陆操作", notes="登录处理")
    @PostMapping(value = "/emp_login")
    @ResponseBody
    public String login(BmEmp bmEmp, HttpSession session){
        boolean ind = bmEmp==null || "".equals(bmEmp)?false:true;
        //登陆时没有收到用户名和密码！
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.LOGINPARAMETERNUL.getText());}
        BmEmp loginemp = bmEmpMapper.selectById(bmEmp.getEmpId());
        if (loginemp==null || "".equals(loginemp)){
            throw new GeneralException(1,"用户不存在!");
        }
        String empPwd = loginemp.getEmpPwd();
        if (bmEmp.getEmpPwd().equals(empPwd)){
            BmDept bmDept = bmDeptMapper.selectById(loginemp.getEmpDept());
            session.setAttribute("emp",loginemp);
            session.setAttribute("dept",bmDept);
            return JsonResult.failed(0, "登录成功！",null);
        }
        throw new GeneralException(2,"登录密码错误！");
    }

    @MyAop(value = "用户注册")
    @ApiOperation(value="用户注册", notes="注册")
    @PostMapping(value = "/emp_register")
    @ResponseBody
    public int register(BmEmp bmEmp){
        boolean ind = bmEmp==null || "".equals(bmEmp)?false:true;
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.REGISTERPARAMETERNUL.getText());}
        int sign ;
        sign=bmEmpMapper.insert(bmEmp);
        return sign;
    }


    @MyAop(value = "修改用户信息")
    @ApiOperation(value="用户修改信息", notes="修改")
    @PostMapping(value = "/sys/emp_upd")
    @ResponseBody
    public int upd(BmEmp bmEmp,HttpSession session){
        boolean ind = bmEmp==null || "".equals(bmEmp)?false:true;
        if (!ind){throw new  IllegalArgumentException(ErrorMessage.REGISTERPARAMETERNUL.getText());}
        int sign = bmEmpMapper.updateById(bmEmp);
        return sign;
    }

    @MyAop(value = "密码校验")
    @ApiOperation(value="密码验证", notes="密码验证")
    @PostMapping(value = "/sys/pwd")
    @ResponseBody
    public int pwds(@RequestParam(value = "pwd",required = true) String pwd,
                    HttpSession session){
        BmEmp bmEmp1 = (BmEmp)session.getAttribute("emp");
        int sign ;
        if (pwd.equals(bmEmp1.getEmpPwd())){
            sign=0;
        }else {
            sign=1;
        }
        return sign;
    }

    @MyAop(value = "退出操作")
    @ApiOperation(value="退出登录", notes="退出")
    @GetMapping(value = "/sys/outlogin")
    public String outlogin(HttpSession session){
        session.removeAttribute("emp");
        return "redirect:/login";
    }







}

