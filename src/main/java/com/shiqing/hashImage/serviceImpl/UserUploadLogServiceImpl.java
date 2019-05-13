package com.shiqing.hashImage.serviceImpl;

import com.shiqing.hashImage.bean.UrlImage;
import com.shiqing.hashImage.dao.UserUploadLogDao;
import com.shiqing.hashImage.service.UserUploadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUploadLogServiceImpl implements UserUploadLogService {
    @Autowired
    UserUploadLogDao userUploadLogDao;
    @Override
    public List<UrlImage> findAllByUserId(Long userId) {
        return userUploadLogDao.findAllByUserId(userId);
    }

    @Override
    public void save(UrlImage image) {
        userUploadLogDao.save(image);
    }
}
