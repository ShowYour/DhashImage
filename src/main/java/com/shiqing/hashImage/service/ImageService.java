package com.shiqing.hashImage.service;

import com.shiqing.hashImage.bean.Image;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 12:59 2019/5/11
 * @description:
 */
public interface ImageService {
    void saveImage(Image image);
    Image findImageByDhash(String dhash);
    List<Image> findImagesByUserId(Long userId);
    List<Image> getAllImages();
}
