package com.monoya.my.cake.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类传输对象
 */
@Data
public class CakeCategoryDTO implements Serializable {
    private Long id;
    private String name;
}
