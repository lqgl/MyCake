package com.monoya.my.cake.web.ui.controller;

import com.monoya.my.cake.web.ui.api.CakesApi;
import com.monoya.my.cake.web.ui.dto.Cake;
import com.monoya.my.cake.web.ui.dto.Ppt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 首页
 */
@Controller
public class IndexController {
    /**
     * 跳转到首页
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model) throws Exception {
        //获取首页轮播图
        List<Ppt> pptList = CakesApi.ppt();
        //获取tabs
        List<Cake> tabList = CakesApi.tabs();
        model.addAttribute("pptList",pptList);
        model.addAttribute("tabList",tabList);
        return "index";
    }

}
