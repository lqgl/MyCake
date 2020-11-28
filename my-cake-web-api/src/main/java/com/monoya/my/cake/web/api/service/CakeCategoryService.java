package com.monoya.my.cake.web.api.service;

import com.monoya.my.cake.domain.CakeCategory;

import java.util.List;

public interface CakeCategoryService {
    /**
     * 查询所有商品分类
     * @return
     */
    List<CakeCategory> selectCakeCategories();
}
