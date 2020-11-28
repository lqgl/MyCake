package com.monoya.my.cake.web.admin.service;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.domain.Cake;

import java.util.List;

public interface CakeService {

    /**
     * 更新用户信息
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
     * 保存信息
     * @param cake
     */
    BaseResult save(Cake cake);

    /**
     * 根据 id 删除信息
     */
    void delete(Long id);


    /**
     * 数据总记录数
     * @return
     */
    int count(Cake cake);

    /**
     * 分页
     * @param start 开始的位置
     * @param length 要显示的记录的条数
     * @return
     */
    PageInfo<Cake> page(int draw, int start, int length, Cake cake);

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
