package com.monoya.my.cake.web.api.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.domain.CakeCategory;
import com.monoya.my.cake.web.api.service.CakeService;
import com.monoya.my.cake.web.api.web.dto.CakeCategoryDTO;
import com.monoya.my.cake.web.api.web.dto.CakeDTO;
import com.monoya.my.cake.web.api.web.dto.PptDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.path.v1}/ppts")
public class PptController {
    @Autowired
    private CakeService cakeService;
    /**
     * 根据类别 id 查询ppt列表
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(){
        List<PptDTO> pptDTOS = null;
        List<Cake> cakes = cakeService.selectByCategoryId(147L);
        if(cakes != null&& cakes.size()>0){
            pptDTOS = new ArrayList<>();
            for (Cake cake : cakes) {
                PptDTO dto = new PptDTO();
                BeanUtils.copyProperties(cake,dto);
                pptDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",pptDTOS);
    }
}
