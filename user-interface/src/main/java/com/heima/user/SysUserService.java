package com.heima.user;

import com.heima.po.user.UserPo;

/**
 * 同步用户服务
 *
 * @author cjw
 */
public interface SysUserService {

    UserPo getByUsername(String username);

}
