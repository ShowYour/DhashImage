package com.shiqing.hashImage.bean;

import java.util.Date;

/**
 * @author：xiaoyu
 * @create： 12:55 2019/5/11
 * @description:
 */
public class Image {

    private Integer id;

    private String imageName;

    private String imagePath;

    private String imageDhash;

    private String imageType;

    private Date createTime;

    private Long userId;

    private Integer hanm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageDhash() {
        return imageDhash;
    }

    public void setImageDhash(String imageDhash) {
        this.imageDhash = imageDhash;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
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

    public Integer getHanm() {
        return hanm;
    }

    public void setHanm(Integer hanm) {
        this.hanm = hanm;
    }
}
