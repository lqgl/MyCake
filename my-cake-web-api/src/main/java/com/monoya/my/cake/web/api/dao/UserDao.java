package com.monoya.my.cake.web.api.dao;

import com.monoya.my.cake.domain.User;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 */
@Repository
public interface UserDao {
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询是否存在
     * @param user
     * @return
     */
    Integer exists(User user);

    /**
     * 新增会员
     * @param user
     */
    void addUser(User user);
}
