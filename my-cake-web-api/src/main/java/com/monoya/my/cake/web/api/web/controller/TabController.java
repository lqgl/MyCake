package com.monoya.my.cake.web.api.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.web.api.service.CakeService;
import com.monoya.my.cake.web.api.web.dto.CakeDTO;
import com.monoya.my.cake.web.api.web.dto.PptDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.path.v1}/tabs")
public class TabController {
    @Autowired
    private CakeService cakeService;
    /**
     * 根据类别 id 查询tabs列表
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(){
        List<CakeDTO> tabsDTOS = null;
        List<Cake> cakes = cakeService.selectByCategoryId(148L);
        if(cakes != null&& cakes.size()>0){
            tabsDTOS = new ArrayList<>();
            for (Cake cake : cakes) {
                CakeDTO dto = new CakeDTO();
                BeanUtils.copyProperties(cake,dto);
                tabsDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",tabsDTOS);
    }
}
