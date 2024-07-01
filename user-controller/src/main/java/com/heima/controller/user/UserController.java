package com.heima.controller.user;

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

    /**
     * 查询用户列表
     */
    @PostMapping("/queryUserList")
    @ResponseBody
    public void queryUserList() {
        return;
    }
}
