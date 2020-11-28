package com.monoya.my.cake.web.admin.web.controller;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.domain.User;
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
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    @ModelAttribute
    public User getUser(Long id){
        User user = null;
        if(id != null){
            user = userService.getById(id);
        }
        else{
            user = new User();
        }
        return user;
    }
    /**
     * 跳转表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 保存用户信息
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(user);
        //成功
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //失败
        else{
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }

    }
    /**
     * 分页
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<User>  page(HttpServletRequest httpServletRequest,User user){
        String  strDraw = httpServletRequest.getParameter("draw");
        String  strStart = httpServletRequest.getParameter("start");
        String  strLength = httpServletRequest.getParameter("length");
        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 :Integer.parseInt(strStart) ;
        int length = strLength == null ? 10 :Integer.parseInt(strLength);
        PageInfo<User> pageInfo = userService.page(start,length,draw,user);
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
            userService.deleteMulti(idArray);
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
    public String detail(User user){
        return "user_detail";
    }
}
