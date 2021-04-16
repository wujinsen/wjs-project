package cn.wjs.controller;


import cn.wjs.util.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeIndexController {

    @RequestMapping("/login")
    public String defaultLogin() {
        return "/login";
    }

    @RequestMapping("/index")
    public String success() {
        return "index";
    }

    @RequestMapping(value = "/sys/login")
    @ResponseBody
    public static R login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println("===subject.getPrincipal(): " + subject.getPrincipal());
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return R.error("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return R.error("密码不正确");
        } catch (LockedAccountException lae) {
            return R.error("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return R.error("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return R.error("用户名或密码不正确！");
        }

//        if (subject.isAuthenticated()) {
//            return "登录成功";
//        } else {
//            token.clear();
//            return "登录失败";
//        }
        return R.ok();
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "/403";
    }

}
