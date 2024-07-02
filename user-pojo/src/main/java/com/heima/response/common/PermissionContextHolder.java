package com.heima.response.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限控制
 *
 * @author cjw
 */
@Data
public class PermissionContextHolder implements Serializable {
    private static final long serialVersionUID = 7382769060354149374L;

    private static String context = "";

    /**
     * 权限
     */
    public static void setContext(String permission) {
        context = permission;
    }
}
