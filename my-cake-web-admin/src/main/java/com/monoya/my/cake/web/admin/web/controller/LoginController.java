package com.monoya.my.cake.web.admin.web.controller;

import com.monoya.my.cake.commons.constants.ConstantUtils;
import com.monoya.my.cake.domain.User;
import com.monoya.my.cake.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录逻辑
     * @param email 邮箱
     * @param password 密码
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest httpServletRequest){
        User user = userService.login(email, password);
        //登录失败
        if(user == null){
            model.addAttribute("message","邮箱或密码错误,请重新输入");
            return login();
        }
        //登录成功
        else {
            //将登录信息放入会话中
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
