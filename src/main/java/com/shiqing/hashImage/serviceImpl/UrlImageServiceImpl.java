package com.shiqing.hashImage.serviceImpl;

import com.shiqing.hashImage.bean.UrlImage;
import com.shiqing.hashImage.dao.UrlImageDao;
import com.shiqing.hashImage.service.UrlImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 15:19 2019/5/11
 * @description:
 */
@Service
public class UrlImageServiceImpl implements UrlImageService {
    @Autowired
    UrlImageDao urlImageDao;
    @Override
    public void saveUrlImage(UrlImage urlImage) {
        urlImageDao.save(urlImage);
    }

    @Override
    public List<UrlImage> findUrlImagesByUserId(Long userId) {
        return urlImageDao.findAllByUserId(userId);
    }

    @Override
    public UrlImage findUrlImageById(Long id) {
        return urlImageDao.findUrlImageById(id);
    }

    @Override
    public void deleteUrlImageById(Long id) {

    }
}
