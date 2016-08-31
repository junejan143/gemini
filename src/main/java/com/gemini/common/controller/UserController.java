package com.gemini.common.controller;

import com.gemini.common.domain.user.User;
import com.gemini.common.domain.user.UserInfo;
import com.gemini.common.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 章源辰
 * @time: 16/8/30 22:23
 * @describion:
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     * @param userInfo
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public int register(@RequestBody @Valid UserInfo userInfo){
        return userService.register(userInfo);
    }
    /**
     * 用户登录
     * @return 登录的用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User userLogin() {
        return this.userService.userLogin();
    }
}
