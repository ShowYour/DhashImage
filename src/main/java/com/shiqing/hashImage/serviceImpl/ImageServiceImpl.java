package com.shiqing.hashImage.serviceImpl;

import com.shiqing.hashImage.bean.Image;
import com.shiqing.hashImage.dao.ImageDao;
import com.shiqing.hashImage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 14:55 2019/5/11
 * @description:
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public void saveImage(Image image) {
        imageDao.save(image);
    }

    @Override
    public Image findImageByDhash(String dhash) {
        return imageDao.findByImageDhash(dhash);
    }

    @Override
    public List<Image> findImagesByUserId(Long userId) {
        return imageDao.findAllByUserId(userId);
    }

    @Override
    public List<Image> getAllImages() {
        return imageDao.getAllImages();
    }


}
