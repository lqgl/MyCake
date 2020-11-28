package com.monoya.my.cake.web.admin.dao;

import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    /**
     * 根据 email 查询用户信息
     * @return
     */
    User getByEmail(String email);

    /**
     * 更新信息
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
     * 新增信息
     * @param user
     */
    void insert(User user);

    /**
     * 根据 id 删除信息
     */
    void delete(Long id);

    /**
     * 查询全部信息
     * @return
     */
    List<User> selectAll();

    /**
     * 数据总记录数
     * @return
     */
    int count(User uer);

    /**
     * 分页
     * @param params
     * @return
     */
    List<User> page(Map<String,Object> params);

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
