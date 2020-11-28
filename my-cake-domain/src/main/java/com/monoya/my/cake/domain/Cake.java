package com.monoya.my.cake.domain;

import com.monoya.my.cake.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 商品
 */
@Data
public class Cake extends BaseEntity {
    @Length(min = 1,max = 20,message = "标题长度介于1-20个字符之间")
    private String cakeName;
    @Length(min = 1,max = 20,message = "标题长度介于1-20个字符之间")
    private String cakeTaste;
    private String pic;
    private String url;
    private Integer price;
    @Length(min = 1,message = "内容不可为空")
    private String cakeDetail;
    @NotNull(message = "父级类目不能为空")
    private CakeCategory cakeCategory;
}
