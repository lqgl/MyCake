package com.monoya.my.cake.web.ui.api;

import com.monoya.my.cake.commons.utils.HttpClientUtils;
import com.monoya.my.cake.commons.utils.MapperUtils;
import com.monoya.my.cake.web.ui.dto.Cake;
import com.monoya.my.cake.web.ui.dto.Ppt;

import java.util.List;

public class   CakesApi {
    /**
     * 请求分类下的商品列表
     * @param categoryId
     * @return
     * @throws Exception
     */
    public static List<Cake> categoryCakes(Long categoryId) throws Exception {
        String json = HttpClientUtils.doGet(API.API_CONTENTS_PRODUCT+categoryId);
        List<Cake> cakes = MapperUtils.json2listByTree(json, "data",Cake.class);
        return cakes;
    }

    /**
     * 请求商品
     * @param id
     * @return
     * @throws Exception
     */
    public static Cake cake(Long id) throws Exception {
        String json = HttpClientUtils.doGet(API.API_PRODUCT+id);
        Cake cake = MapperUtils.json2pojoByTree(json, "data",Cake.class);
        return cake;
    }

    /**
     * 请求轮播图
     * @return
     * @throws Exception
     */
    public static List<Ppt> ppt() throws Exception {
        String json = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        List<Ppt> ppts = MapperUtils.json2listByTree(json,"data",Ppt.class);
        return ppts;
    }
    /**
     * 请求Tabs
     * @return
     * @throws Exception
     */
    public static List<Cake> tabs() throws Exception {
        String json = HttpClientUtils.doGet(API.API_CONTENTS_TABS);
        List<Cake> tabs = MapperUtils.json2listByTree(json,"data",Cake.class);
        return tabs;
    }
    /**
     * 请求全部商品
     * @return
     * @throws Exception
     */
    public static List<Cake> allCakes() throws Exception {
        String json = HttpClientUtils.doGet(API.API_PRODUCT_ALL);
        List<Cake> allCakes = MapperUtils.json2listByTree(json,"data",Cake.class);
        return allCakes;
    }
}
