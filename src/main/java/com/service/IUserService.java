package com.service;

import com.bean.User;

/**
 * Created by yuyu on 2016/10/19.
 */
public interface IUserService {
    User getUserByName(String userName);

    void updateUser(User user);
}
