package com.monoya.my.cake.web.api.service;

import com.monoya.my.cake.domain.Cake;

import java.util.List;

public interface CakeService {

    /**
     * 根据 id 获取信息
     * @param id
     * @return
     */
    Cake getById(Long id);

    /**
     * 根据类别 id 查询该类下所有商品
     * @param categoryId
     * @return
     */
    List<Cake> selectByCategoryId(Long categoryId);

    /**
     * 查询全部商品
     * @return
     */
    List<Cake> selectAllCakes();
}
