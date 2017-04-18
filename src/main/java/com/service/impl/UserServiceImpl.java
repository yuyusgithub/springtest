package com.service.impl;

import com.bean.User;
import com.dao.CommonDao;
import com.dao.UserDao;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuyu on 2016/10/19.
 */

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommonDao commonDao;

    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    public void updateUser(User user) {

        commonDao.saveOrUpdate(user);

    }
}
