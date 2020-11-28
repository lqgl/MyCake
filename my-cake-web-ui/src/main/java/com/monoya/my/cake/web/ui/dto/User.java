package com.monoya.my.cake.web.ui.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String verification;
}
