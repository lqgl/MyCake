package com.monoya.my.cake.web.api.service.impl;

import com.monoya.my.cake.domain.User;
import com.monoya.my.cake.web.api.dao.UserDao;
import com.monoya.my.cake.web.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User user1 = userDao.login(user);
        if(user1 != null){
            //将明文密码加密
            String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            //密码验证
            if(password.equals(user1.getPassword())){
                return user1;
            }
        }
        return null;
    }

    /**
     * 查询是否存在
     * @param user
     * @return
     */
    @Override
    public Boolean exists(User user) {
        int  exists = userDao.exists(user);
        if(exists > 0){
            return true;
        }
        return false;
    }
    /**
     * 新增会员
     * @param user
     */
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

}
