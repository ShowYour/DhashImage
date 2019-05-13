package com.shiqing.hashImage.service;

import com.shiqing.hashImage.bean.UrlImage;

import java.util.List;

/**
 * @author：xiaoyu
 * @create： 15:18 2019/5/11
 * @description:
 */
public interface UrlImageService {
    void saveUrlImage(UrlImage urlImage);
    List<UrlImage> findUrlImagesByUserId(Long userId);
    UrlImage findUrlImageById(Long id);
    void deleteUrlImageById(Long id);
}
