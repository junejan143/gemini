package com.gemini.common.service;

import com.gemini.common.dao.mapper.user.IUserDao;
import com.gemini.common.domain.user.User;
import com.gemini.common.domain.user.UserInfo;
import com.gemini.common.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author 章源辰
 * @time: 16/8/30 22:29
 * @describion:
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public int register(UserInfo userInfo) {
        return 0;
    }

    public User userLogin(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = user.getAuthorities().size() == 0 ? "": user.getAuthorities().get(0).toString();
        switch (role){
            case "ROLE_ADMIN": //管理员
            case "ROLE_MEMBER": //会员
                return user;
            default: //普通用户
                //修改用户登陆时间
//                this.userInfoDao.updateLoginTime(user.getUserId());
//                return this.queryCommonUserbyUser(user);
        }
        return user;
    }


}
