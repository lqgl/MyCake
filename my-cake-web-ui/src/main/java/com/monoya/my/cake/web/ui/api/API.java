package com.monoya.my.cake.web.ui.api;

public class API {
    //主机地址
    public static final String HOST_NAME = "http://localhost:8081/api/v1";

    //会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST_NAME + "/users/login";
    //会员管理接口 - 注册
    public static final String API_USERS_REGISTER = HOST_NAME + "/users/register";
    //全部商品管理接口
    public static final String API_PRODUCT_ALL = HOST_NAME + "/cakes/all";
    //商品分类管理接口
    public static final String API_PRODUCT_CATEGORIES = HOST_NAME + "/categories/cake";

    //分类下商品管理接口
    public static final String API_CONTENTS_PRODUCT = HOST_NAME + "/cakes/categories/";
    //商品管理接口
    public static final String API_PRODUCT = HOST_NAME + "/cakes/";
    //内容查询接口 - 轮播图
    public static final String API_CONTENTS_PPT = HOST_NAME + "/ppts";
    //内容查询接口 - Tabs
    public static final String API_CONTENTS_TABS = HOST_NAME + "/tabs";
}
