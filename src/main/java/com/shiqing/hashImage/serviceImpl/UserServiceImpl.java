package com.shiqing.hashImage.serviceImpl;

import com.shiqing.hashImage.bean.User;
import com.shiqing.hashImage.dao.UserDao;
import com.shiqing.hashImage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 11:49 2019/5/11
 * @description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

}
