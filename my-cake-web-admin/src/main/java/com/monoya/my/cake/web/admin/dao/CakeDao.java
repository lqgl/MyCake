package com.monoya.my.cake.web.admin.dao;

import com.monoya.my.cake.domain.Cake;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CakeDao {

    /**
     * 更新信息
     * @param cake
     */
    void update(Cake cake);

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    Cake getById(Long id);

    /**
     * 新增信息
     * @param cake
     */
    void insert(Cake cake);

    /**
     * 根据 id 删除信息
     */
    void delete(Long id);

    /**
     * 查询全部信息
     * @return
     */
    List<Cake> selectAll();

    /**
     * 数据总记录数
     * @return
     */
    int count(Cake cake);

    /**
     * 分页
     * @param params
     * @return
     */
    List<Cake> page(Map<String,Object> params);

    /**
     * 批量删除
     * @param ids 要删除项的 id
     */
    void deleteMulti(String[] ids);

    /**
     * 搜索
     * @param cake
     * @return
     */
    List<Cake> search(Cake cake);

}
