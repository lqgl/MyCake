package com.monoya.my.cake.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 */
@Data
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;
}
