package com.monoya.my.cake.web.admin.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.domain.CakeCategory;
import com.monoya.my.cake.web.admin.service.CakeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cake/category")
public class CakeCategoryController {

    @Autowired
    private CakeCategoryService cakeCategoryService;

    /**
     * modelAttribute方法会在 requestMapping 之前执行
     * @param id
     * @return
     */
    @ModelAttribute
    public CakeCategory getCategory(Long id){
        CakeCategory cakeCategory = null;

        //id不为空，则从数据库获取
        if(id != null){
            cakeCategory = cakeCategoryService.getById(id);
        }
        else{
            cakeCategory = new CakeCategory();
        }
        return cakeCategory;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<CakeCategory> targetList = new ArrayList<>();
        List<CakeCategory> sourceList = cakeCategoryService.selectAll();
        sortList(sourceList,targetList,0L);
        model.addAttribute("cakeCategories",targetList);
        return "cake_category_list";
    }
    /**
     * 保存分类信息
     * @param cakeCategory
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(CakeCategory cakeCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = cakeCategoryService.save(cakeCategory);

        //保存成功
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/cake/category/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return form(cakeCategory);
        }
    }
    /**
     * 跳转表单
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(CakeCategory cakeCategory){
        return "cake_category_form";
    }
    /**
     * 树形结构
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<CakeCategory> treeData(Long id){
        if(id == null){
            id = 0L;
        }
        return cakeCategoryService.selectByPid(id);
    }
    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 排序后集合
     * @param parentId 父节点 id
     */
    protected void sortList(List<CakeCategory> sourceList, List<CakeCategory> targetList, Long parentId){
        for (CakeCategory sourceEntity : sourceList) {
            if(sourceEntity.getParent().getId().equals(parentId)){
                targetList.add(sourceEntity);

                //判断有没有子节点，如果有子节点则继续追加
                if(sourceEntity.getIsParent()){
                    for (CakeCategory currentEntity : sourceList) {
                        if(currentEntity.getParent().getId().equals(sourceEntity.getId())){
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(Long id){
        cakeCategoryService.delete(id);
        return "redirect:/cake/category/list";
    }
}
