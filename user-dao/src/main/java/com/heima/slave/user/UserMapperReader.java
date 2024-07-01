package com.heima.slave.user;


import com.heima.po.user.UserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户查询
 *
 * @author cjw
 */
@Mapper
public interface UserMapperReader {

    /**
     * 查询用户集合
     *
     * @return
     */
    List<UserPo> queryUserList();
}
