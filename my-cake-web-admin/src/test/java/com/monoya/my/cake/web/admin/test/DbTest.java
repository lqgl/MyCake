package com.monoya.my.cake.web.admin.test;

import com.monoya.my.cake.domain.User;
import com.monoya.my.cake.web.admin.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class DbTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testGetByEmail(){
        User user = userDao.getByEmail("admin@monoya.com");
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        User user = userDao.getById(1L);
        user.setEmail("948735627@qq.com");
        userDao.update(user);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(2L);
        user.setUsername("LiHua");
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        user.setUsername("LiHua");
        user.setPassword(password);
        user.setEmail("lihua@monoya.com");
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userDao.insert(user);
    }
    @Test
    public void testDelete(){
        userDao.delete(2L);
    }

    @Test
    public void testSelectAll(){
        List<User> userList = userDao.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void testPage(){
        Map<String, Object> params = new HashMap<>();
        params.put("start",0);
        params.put("length",5);
        List<User> userList = userDao.page(params);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSearch(){
        User user = new User();
        user.setUsername("lihua");
        user.setPhone("1");
        List<User> userList = userDao.search(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
