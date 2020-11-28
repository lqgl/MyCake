package com.monoya.my.cake.web.api.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.web.api.service.CakeService;
import com.monoya.my.cake.web.api.web.dto.CakeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.path.v1}/cakes")
public class CakeController {
    @Autowired
    private CakeService cakeService;

    @ModelAttribute
    public Cake getCake(Long id){
        Cake cake = null;
        if(id == null){
            cake = new Cake();
        }
        return cake;
    }

    /**
     * 提供一个根据 id 查询商品的接口
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    public BaseResult getById(@PathVariable(value = "id") Long id){
        CakeDTO dto = new CakeDTO();
        Cake cake = cakeService.getById(id);
        BeanUtils.copyProperties(cake,dto);
        return BaseResult.success("成功",dto);
    }

    /**
     * 根据类别 id 查询内容列表
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "categories/{category_id}",method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(@PathVariable(value = "category_id")Long categoryId){
        List<CakeDTO> cakeDTOS = null;
        List<Cake> cakes = cakeService.selectByCategoryId(categoryId);
        if(cakes != null&& cakes.size()>0){
            cakeDTOS = new ArrayList<>();
            for (Cake cake : cakes) {
                CakeDTO dto = new CakeDTO();
                BeanUtils.copyProperties(cake,dto);
                cakeDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",cakeDTOS);
    }

    /**
     * 查询所有商品列表
     * @return
     */
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public BaseResult findContents(){
        List<CakeDTO> cakeDTOS = null;
        List<Cake> cakes = cakeService.selectAllCakes();
        if(cakes != null&& cakes.size()>0){
            cakeDTOS = new ArrayList<>();
            for (Cake cake : cakes) {
                CakeDTO dto = new CakeDTO();
                BeanUtils.copyProperties(cake,dto);
                cakeDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",cakeDTOS);
    }
}
