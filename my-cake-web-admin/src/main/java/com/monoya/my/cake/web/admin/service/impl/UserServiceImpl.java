package com.monoya.my.cake.web.admin.service.impl;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.commons.utils.RegexpUtils;
import com.monoya.my.cake.domain.User;
import com.monoya.my.cake.web.admin.dao.UserDao;
import com.monoya.my.cake.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    @Override
    public User login(String email, String password) {
        User user = userDao.getByEmail(email);
        //登录成功
        if(user != null){
            //明文加密
            String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes());
            //密码验证
            if(digestPassword.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    /**
     * 更新用户信息
     * @param user
     */
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
    /**
     * 保存信息
     * @param user
     */
    @Override
    public BaseResult save(User user) {
        //验证成功与否
        BaseResult baseResult = checkUser(user);
        //成功
        if(baseResult.getStatus() == 200){
            user.setUpdated(new Date());
            //新增用户信息
            if(user.getId() == null){
                user.setCreated(new Date());
                //密码MD5加密
                String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
                user.setPassword(md5Password);
                userDao.insert(user);
            }
            //更新用户信息
            else{
                //密码MD5加密
                String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
                user.setPassword(md5Password);
                userDao.update(user);
            }
            baseResult = BaseResult.success("保存用户信息成功");
        }
        return baseResult;
    }

    /**
     * 根据 id 删除信息
     */
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    /**
     * 数据总记录数
     * @return
     */
    @Override
    public int count(User user) {
        return userDao.count(user);
    }

    /**
     * 分页
     * @param start 开始的位置
     * @param length 要显示的记录的条数
     * @return
     */
    @Override
    public PageInfo<User> page(int start, int length,int draw,User user) {
        PageInfo<User> pageInfo = new PageInfo<>();
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",user);
        List<User> data = userDao.page(params);
        int count = userDao.count(user);
        pageInfo.setDraw(draw);
        pageInfo.setData(data);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setRecordsTotal(count);
        return pageInfo;
    }

    @Override
    public void deleteMulti(String[] ids) {
        userDao.deleteMulti(ids);
    }

    @Override
    public List<User> search(User user) {
        return userDao.search(user);
    }

    public BaseResult checkUser(User user){
        BaseResult baseResult = BaseResult.success();
        if(StringUtils.isBlank(user.getUsername())){
            baseResult = BaseResult.fail(500,"用户名不能为空,请重新输入。");
        }else if(StringUtils.isBlank(user.getPhone())&& !RegexpUtils.checkPhone(user.getPhone())){
            baseResult = BaseResult.fail(500,"手机号不能为空,请重新输入。");
        }else if(StringUtils.isBlank(user.getPassword())&& !RegexpUtils.checkPhone(user.getPassword())){
            baseResult = BaseResult.fail(500,"密码不能为空,请重新输入。");
        }
        return baseResult;
    }

}
