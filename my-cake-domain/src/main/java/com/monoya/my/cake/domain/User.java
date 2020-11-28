package com.monoya.my.cake.domain;

import com.monoya.my.cake.commons.persistence.BaseEntity;
import lombok.Data;


/**
 * 用户
 */
@Data
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String phone;
}