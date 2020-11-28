package com.monoya.my.cake.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页传输对象
 */
@Data
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String  error;
    private List<T> data;
}
