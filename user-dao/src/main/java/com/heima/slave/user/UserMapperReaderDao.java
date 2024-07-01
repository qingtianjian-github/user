package com.heima.slave.user;

import com.alibaba.druid.support.json.JSONUtils;
import com.heima.po.user.UserPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户查询
 *
 * @author cjw
 */
@Component
@Slf4j
public class UserMapperReaderDao {

    @Autowired
    private UserMapperReader userMapperReader;

    /**
     * 查询用户集合
     *
     * @return
     */
    public List<UserPo> queryUserList() {
        List<UserPo> userPoList;
        try {
            userPoList = userMapperReader.queryUserList();
            log.info("查询用户,返回数据:{}", JSONUtils.toJSONString(userPoList));
        } catch (Exception e) {
            log.error("查询用户失败,异常:", e);
            throw new RuntimeException("查询用户失败");
        }
        return userPoList;
    }
}
