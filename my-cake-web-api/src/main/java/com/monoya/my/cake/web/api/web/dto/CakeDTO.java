package com.monoya.my.cake.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品数据传输对象
 */
@Data
public class CakeDTO implements Serializable {
    private Long id;
    private String cakeName;
    private String cakeTaste;
    private String pic;
    private String url;
    private Integer price;
    private String cakeDetail;
}
