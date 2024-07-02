package com.heima.utils;

import com.heima.response.common.LoginUser;
import com.heima.response.common.ResultEnum;
import com.heima.response.common.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全工具类
 */
public class SecurityUtils {

    /**
     * 获取用户名称
     **/
    public static String getUsername() {
        try {
            return getLoginUser().getUsername();
        } catch (Exception e) {
            throw new ServiceException(ResultEnum.ERROR, "获取用户账户异常");
        }
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getUserId() {
        try {
            return getLoginUser().getUser().getId();
        } catch (Exception e) {
            throw new ServiceException(ResultEnum.ERROR, "获取用户账户异常");
        }
    }

    /**
     * 获取部门id
     *
     * @return
     */
    public static Long getDeptId() {
        try {
            return getLoginUser().getUser().getDeptId();
        } catch (Exception e) {
            throw new ServiceException(ResultEnum.ERROR, "获取用户账户异常");
        }
    }

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new ServiceException(ResultEnum.ERROR, "获取用户信息异常");
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public static Long getAdmin() {
        return 1L;
    }

}
