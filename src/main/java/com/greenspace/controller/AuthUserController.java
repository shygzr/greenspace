package com.greenspace.controller;

import com.alibaba.fastjson.JSONObject;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IUserService;
import com.greenspace.util.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Map;

@RequestMapping("/auth/user")
@Controller
public class AuthUserController extends BaseController {

    @Autowired
    private IAuthUserService iAuthUserService;

    @ResponseBody
    @PostMapping("/ajaxLogin")
    public Object ajaxLogin(@RequestParam Map<String,Object> params) {
        Serializable gToken = null;
        String msg = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(params.get("userName").toString(), params.get("passWord").toString());
        try {
            subject.login(token);
            gToken = subject.getSession().getId();
            msg = "登录成功";
            return ajaxDoneSuccess(msg).put("token", gToken);
        } catch (IncorrectCredentialsException e) {
            msg = "密码错误";
        } catch (LockedAccountException e) {
            msg = "登录失败，该用户已被冻结";
        } catch (AuthenticationException e) {
            msg = "该用户不存在";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxDoneError(msg);
    }

    @ResponseBody
    @RequestMapping("/unauth")
    public Object unauth(@RequestParam Map<String,Object> params) {
        return ajaxDoneError("未登录").put("code", "1000000");
    }


    //测试是否登录
    @ResponseBody
    @RequestMapping("/index")
    @RequiresPermissions("authUser:index")
    public Object index(@RequestParam Map<String,Object> params) {
        return ajaxDoneSuccess("已登录");
    }




//    @ResponseBody
//    @PostMapping("/g")
//    public Object login(@RequestParam Map<String,Object> params, HttpServletRequest request) {
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "账号不存在";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "密码不正确";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        return ajaxDoneError(msg);
//    }


    @ResponseBody
    @RequestMapping("/test")
    @RequiresPermissions("authUser:test")
//    @RequiresRoles("administrator")
    public Object index(){
        System.out.println("登录成功");
        return ajaxDoneSuccess("登录成功1");
    }

    //测试硬件
    @ResponseBody
    @GetMapping("/testY")
    public Object testY(){
        System.out.println("Test");
        return ajaxDoneSuccess("Success!");
    }
}
