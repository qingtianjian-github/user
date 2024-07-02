package com.heima.response.common;

import com.heima.po.user.UserPo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 登录用户
 */
@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -4227852974571638183L;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户实例
     */
    private UserPo user;

    /**
     * 权限
     */
    private Set<String> permissions;
}
