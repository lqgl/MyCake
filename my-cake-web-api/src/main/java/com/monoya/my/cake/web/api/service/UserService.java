package com.monoya.my.cake.web.api.service;

import com.monoya.my.cake.domain.User;

public interface UserService {

    /**
     * 根据邮箱查询信息
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询是否存在
     * @param user
     * @return
     */
    Boolean exists(User user);

    /**
     * 新增会员
     * @param user
     */
    void addUser(User user);
}
