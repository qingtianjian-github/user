package com.heima.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 用户服务
 *
 * @author cjw
 */
public interface UserDetailService {

    /**
     * 获取用户权限
     *
     * @param id
     * @return
     */
    Collection<? extends GrantedAuthority> getUserAuthority(Long id);
}
