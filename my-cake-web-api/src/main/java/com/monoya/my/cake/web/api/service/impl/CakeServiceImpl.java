package com.monoya.my.cake.web.api.service.impl;

import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.web.api.dao.CakeDao;
import com.monoya.my.cake.web.api.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeServiceImpl implements CakeService {

    @Autowired
    private CakeDao cakeDao;
    /**
     * 根据 id 获取信息
     * @param id
     * @return
     */
    @Override
    public Cake getById(Long id) {
        return cakeDao.getById(id);
    }

    /**
     * 根据类别 id 查询该类下所有商品
     * @param categoryId
     * @return
     */
    @Override
    public List<Cake> selectByCategoryId(Long categoryId) {
        return cakeDao.selectByCategoryId(categoryId);
    }

    /**
     * 查询全部商品
     * @return
     */
    @Override
    public List<Cake> selectAllCakes() {
        return cakeDao.selectAllCakes();
    }


}
