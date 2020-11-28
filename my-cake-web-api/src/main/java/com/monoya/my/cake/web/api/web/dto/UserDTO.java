package com.monoya.my.cake.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员数据传输对象
 */
@Data
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
}
