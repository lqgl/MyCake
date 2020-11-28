package com.monoya.my.cake.web.admin.service;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     * 保存信息
     * @param user
     */
    BaseResult save(User user);

    /**
     * 根据 id 删除信息
     */
    void delete(Long id);


    /**
     * 数据总记录数
     * @return
     */
    int count(User user);

    /**
     * 分页
     * @param start 开始的位置
     * @param length 要显示的记录的条数
     * @return
     */
    PageInfo<User> page( int draw,int start, int length,User user);

    /**
     * 批量删除
     * @param ids 要删除项的 id
     */
    void deleteMulti(String[] ids);

    /**
     * 搜索
     * @param user
     * @return
     */
    List<User> search(User user);
}
