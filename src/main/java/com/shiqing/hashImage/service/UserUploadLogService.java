package com.shiqing.hashImage.service;

import com.shiqing.hashImage.bean.UrlImage;
import java.util.List;

public interface UserUploadLogService {
    List<UrlImage> findAllByUserId(Long userId);
    void save(UrlImage image);
}
