package com.monoya.my.cake.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.monoya.my.cake.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 商品分类
 */
@Data
public class CakeCategory extends BaseEntity {
    @Length(min = 1,max = 20,message = "标题长度介于1-20个字符之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
    @NotNull(message = "父级类目不能为空")
    private CakeCategory parent;
}
