package com.monoya.my.cake.web.ui.controller;

import com.monoya.my.cake.web.ui.api.CakeCategoriesApi;
import com.monoya.my.cake.web.ui.api.CakesApi;
import com.monoya.my.cake.web.ui.dto.Cake;
import com.monoya.my.cake.web.ui.dto.CakeCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ListController {


    /**
     * 分类下的所有商品
     * @param redirectAttributes
     * @param categoryId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "categoryCakes/{categoryId}",method = RequestMethod.GET)
    public String categories(Model model,RedirectAttributes redirectAttributes, @PathVariable(value = "categoryId") Long categoryId) throws Exception {
        //请求分类数据
        List<Cake> cakeList = CakesApi.categoryCakes(categoryId);
        redirectAttributes.addFlashAttribute("cakeList",cakeList);
        return "redirect:/list";
    }

    /**
     * 跳转列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model,HttpServletRequest httpServletRequest) throws Exception {
        //商品分类列表
        List<CakeCategory> cakeCategoryList = CakeCategoriesApi.categories();
        httpServletRequest.getSession().setAttribute("cakeCategoryList",cakeCategoryList);
        //全部商品
        List<Cake> allCakesList = CakesApi.allCakes();
        model.addAttribute("allCakesList",allCakesList);
        return "list";
    }
}
