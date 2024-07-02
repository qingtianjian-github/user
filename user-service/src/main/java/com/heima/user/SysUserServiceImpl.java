package com.heima.user;

import com.heima.po.user.UserPo;
import org.springframework.stereotype.Service;

/**
 * 同步用户服务
 *
 * @author cjw
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    /**
     * 根据名称获取用户
     *
     * @param username
     * @return
     */
    @Override
    public UserPo getByUsername(String username) {
        return null;
    }
}
