package com.heima.user;

import com.heima.po.user.UserPo;
import com.heima.response.common.AccountUser;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户详情服务
 *
 * @author cjw
 */
@DubboService
public class UserDetailServiceImpl implements UserDetailsService, UserDetailService {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 通过用户名称获取用户
     *
     * @param userName
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {
        //通过用户名称查询用户详情
        //todo：UserPo userPo = sysUserService.getByUsername(userName);
        UserPo userPo = new UserPo();
        if (userPo == null) {
            throw new RuntimeException("用户名或密码错误");
        }
        return new AccountUser(userPo.getId(), userPo.getUserName(), userPo.getUserPassword(), getUserAuthority(userPo.getId()));
    }

    /**
     * 获取用户权限信息（角色、菜单权限）
     *
     * @param userId
     * @return
     */
    @Override
    public List<GrantedAuthority> getUserAuthority(Long userId) {
        // 实际怎么写以数据表结构为准，这里只是写个例子
        // 角色(比如ROLE_admin)，菜单操作权限(比如sys:user:list)
        // 比如ROLE_admin,ROLE_normal,sys:user:list,...
        //todo：String authority = sysUserService.getUserAuthorityInfo(userId);
        String authority = "";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}