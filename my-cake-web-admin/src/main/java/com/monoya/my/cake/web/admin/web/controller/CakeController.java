package com.monoya.my.cake.web.admin.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.web.admin.service.CakeService;
import com.monoya.my.cake.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping(value = "cake")
public class CakeController {
    @Autowired
    private CakeService cakeService;

    /**
     * 跳转到列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "cake_list";
    }

    /**
     * modelAttribute方法会在 requestMapping 之前执行
     * @param id
     * @return
     */
    @ModelAttribute
    public Cake getCake(Long id){
        Cake cake = null;
        if(id != null){
            cake = cakeService.getById(id);
        }
        else{
            cake = new Cake();
        }
        return cake;
    }
    /**
     * 跳转表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "cake_form";
    }

    /**
     * 保存信息
     * @param cake
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Cake cake, RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = cakeService.save(cake);
        //成功
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/cake/list";
        }
        //失败
        else{
            model.addAttribute("baseResult",baseResult);
            return "cake_form";
        }

    }
    /**
     * 分页
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<Cake> page(HttpServletRequest httpServletRequest, Cake cake){
        String  strDraw = httpServletRequest.getParameter("draw");
        String  strStart = httpServletRequest.getParameter("start");
        String  strLength = httpServletRequest.getParameter("length");
        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 :Integer.parseInt(strStart) ;
        int length = strLength == null ? 10 :Integer.parseInt(strLength);
        PageInfo<Cake> pageInfo = cakeService.page(start,length,draw,cake);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids 接受的 ajax 发送的参数（要删除项的 id ）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String ids){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            cakeService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户信息成功");
        }
        else{
            baseResult = BaseResult.fail("删除用户信息失败");
        }
        return baseResult;
    }

    /**
     * 显示用户详情
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Cake cake){
        return "cake_detail";
    }

}
