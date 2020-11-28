package com.monoya.my.cake.web.api.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.User;
import com.monoya.my.cake.web.api.service.UserService;
import com.monoya.my.cake.web.api.web.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 会员管理
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 会员登录接口
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(User user){
        User user1 = userService.login(user);
        if(user1 == null){
            return BaseResult.fail("用户名或密码错误");
        }

        else{
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(user1,dto);
            return BaseResult.success("成功",dto);
        }
    }

    /**
     * 会员注册接口
     * @param user 会员注册信息
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(User user){
        Boolean exist = userService.exists(user);
        if(exist){
            return BaseResult.fail("用户名已存在");
        }else{
            user.setCreated(new Date());
            user.setUpdated(new Date());
            //密码 md5 加密
            String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(password);
            userService.addUser(user);
            return BaseResult.success("新增会员成功");
        }

    }
}
