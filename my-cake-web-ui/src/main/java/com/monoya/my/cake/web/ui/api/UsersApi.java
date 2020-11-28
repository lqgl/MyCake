package com.monoya.my.cake.web.ui.api;

import com.monoya.my.cake.commons.utils.HttpClientUtils;
import com.monoya.my.cake.commons.utils.MapperUtils;
import com.monoya.my.cake.web.ui.dto.User;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 */
public class UsersApi {
    /**
     * 请求登录接口
     * @param user
     * @return
     * @throws Exception
     */
    public static User login(User user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",user.getUsername()));
        params.add(new BasicNameValuePair("password",user.getPassword()));
        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN,params.toArray(new BasicNameValuePair[params.size()]));
        User user1 = MapperUtils.json2pojoByTree(json, "data", User.class);
        return user1;
    }

    /**
     * 请求注册接口
     * @param user
     * @return
     * @throws Exception
     */
    public static int register(User user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",user.getUsername()));
        params.add(new BasicNameValuePair("password",user.getPassword()));
        params.add(new BasicNameValuePair("email",user.getEmail()));
        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER,params.toArray(new BasicNameValuePair[params.size()]));
        int result = MapperUtils.json2pojoByTree(json, "status", Integer.class);
        return result;
    }
}
