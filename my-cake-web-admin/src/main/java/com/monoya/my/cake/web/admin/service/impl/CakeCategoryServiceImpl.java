package com.monoya.my.cake.web.admin.service.impl;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.validator.BeanValidator;
import com.monoya.my.cake.domain.CakeCategory;
import com.monoya.my.cake.web.admin.dao.CakeCategoryDao;
import com.monoya.my.cake.web.admin.service.CakeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CakeCategoryServiceImpl implements CakeCategoryService {
    @Autowired
    private CakeCategoryDao cakeCategoryDao;
    /**
     * 查询所有类目
     * @return
     */
    @Override
    public List<CakeCategory> selectAll() {
        return cakeCategoryDao.selectAll();
    }
    /**
     * 根据父级节点 id 查询所有子节点
     * @param id 父级节点 id
     * @return
     */
    @Override
    public List<CakeCategory> selectByPid(Long id) {
        return cakeCategoryDao.selectByPid(id);
    }

    /**
     * 保存信息
     * @param cakeCategory
     * @return
     */
    @Override
    public BaseResult save(CakeCategory cakeCategory) {
        String validator = BeanValidator.validator(cakeCategory);
        //验证未通过
        if(validator!=null){
           return BaseResult.fail(validator);
        }
        //验证通过
        else {
            CakeCategory parent = cakeCategory.getParent();
            //如果没有选择父级节点则设置为根目录
            if(parent == null || parent.getId() == null){
                // 0 代表根目录
                parent.setId(0L);

            }

            cakeCategory.setUpdated(new Date());
            //新增
            if(cakeCategory.getId() == null){
                cakeCategory.setCreated(new Date());
                cakeCategory.setIsParent(false);

                //判断当前新增的节点有没有父级节点
                if(parent.getId() != 0L){
                    CakeCategory currentCategoryParent = getById(parent.getId());
                    if(currentCategoryParent != null){
                        //为父级节点设置 isParent 为 true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }

                //父级节点为 0 ，代表为根目录
                else {
                    //根目录一定是父级目录
                    cakeCategory.setIsParent(true);
                }

                cakeCategoryDao.insert(cakeCategory);
            }
            //修改
            else {
                cakeCategoryDao.update(cakeCategory);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete(Long id) {
        cakeCategoryDao.delete(id);
    }

    @Override
    public CakeCategory getById(Long id) {
        return cakeCategoryDao.getById(id);
    }

    @Override
    public void update(CakeCategory cakeCategory) {
        cakeCategoryDao.update(cakeCategory);
    }

}
