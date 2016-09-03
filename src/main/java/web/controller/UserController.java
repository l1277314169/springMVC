package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.po.User;
import web.service.UserService;

import java.util.List;

/**
 * Created by liuhonger on 2016/3/29.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService   userService;
    @RequestMapping(value = "/show")
    public String show(Model model){
        User user = userService.findByUsername("liuhonger");
        model.addAttribute("users",user);
        return "user";
    }
}
