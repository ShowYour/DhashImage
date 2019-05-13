package com.shiqing.hashImage.bean;

import java.util.Date;

/**
 * @author：xiaoyu
 * @create： 15:10 2019/5/11
 * @description:
 */

public class UrlImage {

    private Integer id;

    private String imageUrl;

    private Date createTime;

    private Long userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
