package com.heima.user;


import com.heima.response.common.BaseResponse;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 用户服务
 *
 * @author cjw
 */
public interface UserService {

    BaseResponse queryUserList();
}
