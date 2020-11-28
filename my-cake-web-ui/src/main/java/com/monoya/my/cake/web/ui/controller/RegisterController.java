package com.monoya.my.cake.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.web.ui.api.UsersApi;
import com.monoya.my.cake.web.ui.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * 注册状态
     * @param user
     * @param model
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(User user, Model model,HttpServletRequest httpServletRequest) throws Exception {
        //验证验证码
        if(!checkVerification(user,httpServletRequest)){
            model.addAttribute("baseResult",BaseResult.fail("验证码错误，请重新输入！"));
            return "register";
        }
        //接收注册状态
        int  result = UsersApi.register(user);
        if(result != 200){
            model.addAttribute("baseResult", BaseResult.fail("用户名或邮箱已存在"));
            return "register";
        }
        //注册成功
        else{
            //发送注册成功的信息
            sendEmail(user);
            return "redirect:/login";
        }
    }

    /**
     * 发送邮件
     * @param user
     * @throws EmailException
     */
    public void sendEmail(User user) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("发件人邮箱", "授权码"));
        email.setSSLOnConnect(true);
        email.setFrom("发件人邮箱");
        email.setSubject("My Cake会员注册成功！");
        email.setMsg(String.format("恭喜 【%s】成功注册My Cake会员，普天同庆，可喜可贺！",user.getUsername()));
        email.addTo(user.getEmail());
        email.send();
    }

    /**
     * 验证码校验
     * @param user
     * @param httpServletRequest
     * @return
     */
     public boolean checkVerification(User user, HttpServletRequest httpServletRequest){
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
