package com.monoya.my.cake.web.ui.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Cake implements Serializable {
    private Long id;
    private String cakeName;
    private String cakeTaste;
    private String pic;
    private String url;
    private Integer price;
    private String cakeDetail;
}
