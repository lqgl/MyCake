package com.monoya.my.cake.web.ui.controller;

import com.monoya.my.cake.web.ui.api.CakesApi;
import com.monoya.my.cake.web.ui.dto.Cake;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ProductController {
    @ModelAttribute
    public Cake cake(Long id){
        Cake cake = null;
        if(id == null){
            cake = new Cake();
        }
        return cake;
    }

    /**
     * 跳转商品页
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "products/{id}",method = RequestMethod.GET)
    public String product(Model model, @PathVariable(value = "id") Long id) throws Exception {
        Cake cake = CakesApi.cake(id);
        model.addAttribute("cake",cake);
        return "product";
    }

}
