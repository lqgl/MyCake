package com.monoya.my.cake.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类传输对象
 */
@Data
public class CakeCategory implements Serializable {
    private Long id;
    private String name;
}
