package com.greenspace.controller;

import com.greenspace.dao.UserMapper;
import com.greenspace.service.IUserService;
import com.greenspace.util.BaseController;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

//@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;
    
    @ResponseBody
    @PostMapping("/login")
    public Object login(@RequestParam Map<String,Object> params, HttpServletRequest request) {
//        String userName = params.get("userName").toString();
//        String passWord = params.get("passWord").toString();
//        HttpSession session = request.getSession();
//        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
//            return ajaxDoneError("帐号或密码不能为空");
//        }
//        Long userId = userService.checkPassword(userName, passWord);
//        if(userId != null){
//            session.setAttribute("userName", userName);
//            session.setAttribute("userId",userId);
//            session.setAttribute("gzzr_code","gzzr_Xmxcnuumeo_gzzr");
//            return ajaxDoneSuccess("登录成功");
//        } else {
//            return ajaxDoneError("帐号或密码错误");
//        }
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        return ajaxDoneError(msg);
        // 此方法不处理登录成功,由shiro进行处理

    }

    @ResponseBody
    @GetMapping("/test")
    public Object test() {
        return ajaxDoneSuccess("gettttt");
    }

    @ResponseBody
    @PostMapping("/test")
    public Object test1() {
        return ajaxDoneSuccess("postttttt");
    }

    @ResponseBody
    @PutMapping("/test")
    public Object test2() {
        return ajaxDoneSuccess("puttttt");
    }

    @ResponseBody
    @DeleteMapping("/test")
    public Object test3() {
        return ajaxDoneSuccess("deleteeeee");
    }

}
