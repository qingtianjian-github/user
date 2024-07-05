package com.heima.user;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.heima.config.TargetDataSource;
import com.heima.po.user.UserPo;
import com.heima.response.common.BaseResponse;
import com.heima.response.common.ResultEnum;
import com.heima.response.user.UserResponse;
import com.heima.slave.user.UserMapperReaderDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务
 *
 * @author cjw
 */
@DubboService
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperReaderDao userMapperReaderDao;

    /**
     * 查询用户列表
     *
     * @return
     */
    @TargetDataSource(name = "slave")
    @Override
    public BaseResponse queryUserList() {
        //查询用户集合
        List<UserPo> userPoList = userMapperReaderDao.queryUserList();
        if (CollectionUtils.isEmpty(userPoList)) {
            return new BaseResponse(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), new ArrayList<>());
        }
        List<UserResponse> userResponseList = userPoList.stream().map(item -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(item, userResponse);
            return userResponse;
        }).collect(Collectors.toList());
        return new BaseResponse(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), userResponseList);
    }

}
