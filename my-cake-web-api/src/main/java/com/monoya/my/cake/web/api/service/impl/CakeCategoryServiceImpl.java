package com.monoya.my.cake.web.api.service.impl;

import com.monoya.my.cake.domain.CakeCategory;
import com.monoya.my.cake.web.api.dao.CakeCategoryDao;
import com.monoya.my.cake.web.api.service.CakeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CakeCategoryServiceImpl implements CakeCategoryService {
    @Autowired
    private CakeCategoryDao cakeCategoryDao;
    /**
     * 查询所有商品分类
     * @return
     */
    @Override
    public List<CakeCategory> selectCakeCategories() {
        return cakeCategoryDao.selectCakeCategories();
    }
}
