package web.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.po.User;



/**
 * Created by Administrator on 2016-05-01.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginAuthenticationFilter {

    private static final Log log = LogFactory.getLog(LoginAuthenticationFilter.class);

    @RequestMapping(value = "/login")
    public String login(Model model,User user) throws UnknownAccountException {
        String errorInfo="";
        UsernamePasswordToken usernamePasswordToken =new UsernamePasswordToken(user.getUserName(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {//用户名没有找到
            errorInfo="用户名没有找到";
        } catch (IncorrectCredentialsException e) {//用户名密码不匹配
            errorInfo="用户名密码不匹配";
        }catch (LockedAccountException e){//账户被锁
            errorInfo="用户账户被锁";
        }catch (AuthenticationException e) {//其他的登录错误
            errorInfo="身份验证失败";
        }
        model.addAttribute("message",errorInfo);
        //验证是否成功登录的方法
        if (subject.isAuthenticated()) {
            return "redirect:/welcome.ftl";
        }
        return "/login.ftl";
    }

    //退出
    @RequestMapping("/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
@RequestMapping(value = "/show")
    public String show(){
    System.out.println("asdf");
    System.out.println("asd68789");
    return "/login";
    }

}
