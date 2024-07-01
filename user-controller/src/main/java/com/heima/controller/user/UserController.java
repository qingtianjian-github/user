package com.heima.controller.user;

import com.heima.response.common.BaseResponse;
import com.heima.user.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户
 *
 * @author cjw
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @DubboReference
    private UserService userService;

    /**
     * 查询用户列表
     */
    @PostMapping("/queryUserList")
    @ResponseBody
    public BaseResponse queryUserList() {
        return userService.queryUserList();
    }
}
