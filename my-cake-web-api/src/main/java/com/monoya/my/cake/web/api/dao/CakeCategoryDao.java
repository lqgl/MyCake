package com.monoya.my.cake.web.api.dao;

import com.monoya.my.cake.domain.CakeCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeCategoryDao {
    /**
     * 查询所有商品分类
     * @return
     */
    List<CakeCategory> selectCakeCategories();
}
