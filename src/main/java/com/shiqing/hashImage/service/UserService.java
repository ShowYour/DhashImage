package com.shiqing.hashImage.service;

import com.shiqing.hashImage.bean.User;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 12:11 2019/5/11
 * @description:
 */
public interface UserService {
    User getUserByName(String username);
    User getUserById(Long id);
    void saveUser(User user);
    List<User> getAllUsers();
}
