package com.monoya.my.cake.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.web.ui.api.UsersApi;
import com.monoya.my.cake.web.ui.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest httpServletRequest) throws Exception {
        //验证验证码
        if(!checkVerification(user,httpServletRequest)){
            model.addAttribute("baseResult",BaseResult.fail("验证码错误，请重新输入！"));
            return "login";
        }
        User user1 = UsersApi.login(user);
        //登录失败
        if(user1==null){
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码错误"));
            return login();

        }
        //登录成功
        else {
            //将会员信息放入会话
            httpServletRequest.getSession().setAttribute("User",user1);
            return "redirect:/index";
        }
    }
        @RequestMapping(value = "logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest httpServletRequest){
            httpServletRequest.getSession().invalidate();
            return "redirect:/index";
        }

        public boolean checkVerification(User user,HttpServletRequest httpServletRequest){
            String  verification = (String) httpServletRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            //验证是否一致
            if(StringUtils.equals(user.getVerification(),verification)){
                return true;
            }
            else{
                return false;
            }
        }
}
