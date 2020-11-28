package com.monoya.my.cake.web.admin.service;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.CakeCategory;

import java.util.List;
import java.util.Map;

public interface CakeCategoryService {
    /**
     * 查询所有类目
     * @return
     */
    List<CakeCategory> selectAll();

    /**
     * 根据父级节点 id 查询所有子节点
     * @param id 父级节点 id
     * @return
     */
    List<CakeCategory> selectByPid(Long id);
    /**
     * 新增
     *
     * @param cakeCategory
     */
    BaseResult save(CakeCategory cakeCategory);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 id 查询信息
     *
     * @param id
     */
    CakeCategory getById(Long id);

    /**
     * 更新
     *
     * @param cakeCategory
     */
    void update(CakeCategory cakeCategory);

}
