package com.monoya.my.cake.web.api.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.CakeCategory;
import com.monoya.my.cake.web.api.service.CakeCategoryService;
import com.monoya.my.cake.web.api.web.dto.CakeCategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.path.v1}/categories",method = RequestMethod.GET)
public class CakeCategoryController {
    @Autowired
    private CakeCategoryService cakeCategoryService;

    /**
     * 提供一个查询所有商品分类的接口
     * @return
     */
    @RequestMapping(value = "cake")
    public BaseResult getCakeCategories(){
        List<CakeCategoryDTO> cakeCategoryDTOS = new ArrayList<>();
        List<CakeCategory> cakeCategoryList = cakeCategoryService.selectCakeCategories();
        if(cakeCategoryList!=null&&cakeCategoryList.size()>0){
            for (CakeCategory cakeCategory : cakeCategoryList) {
                CakeCategoryDTO dto = new CakeCategoryDTO();
                 BeanUtils.copyProperties(cakeCategory,dto);
                cakeCategoryDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",cakeCategoryDTOS);
    }
}
