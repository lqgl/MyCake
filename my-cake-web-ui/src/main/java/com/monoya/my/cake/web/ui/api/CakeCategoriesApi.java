package com.monoya.my.cake.web.ui.api;

import com.monoya.my.cake.commons.utils.HttpClientUtils;
import com.monoya.my.cake.commons.utils.MapperUtils;
import com.monoya.my.cake.web.ui.dto.CakeCategory;
import java.util.List;

/**
 * 商品分类管理接口
 */
public class CakeCategoriesApi {
    /**
     * 请求商品分类数据
     * @return
     * @throws Exception
     */
    public static List<CakeCategory> categories() throws Exception {
        String json = HttpClientUtils.doGet(API.API_PRODUCT_CATEGORIES);
        List<CakeCategory> cakeCategories = MapperUtils.json2listByTree(json, "data",CakeCategory.class);
        return cakeCategories;
    }

}
