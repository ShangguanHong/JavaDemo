package com.example.jpa.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sgh
 * @date 2019/8/14 下午6:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}
