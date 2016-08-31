package com.gemini.common.service.impl;

import com.gemini.common.domain.user.User;
import com.gemini.common.domain.user.UserInfo;

/**
 * @author 章源辰
 * @time: 16/8/30 22:28
 * @describion:
 */
public interface IUserService {

    User userLogin();

    int register(UserInfo userInfo);
}
