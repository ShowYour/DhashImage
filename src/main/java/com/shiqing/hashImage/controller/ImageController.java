package com.shiqing.hashImage.controller;

import com.alibaba.fastjson.JSONObject;
import com.shiqing.hashImage.bean.Image;
import com.shiqing.hashImage.bean.UrlImage;
import com.shiqing.hashImage.bean.User;
import com.shiqing.hashImage.service.ImageService;
import com.shiqing.hashImage.service.UrlImageService;
import com.shiqing.hashImage.service.UserService;
import com.shiqing.hashImage.service.UserUploadLogService;
import com.shiqing.hashImage.serviceImpl.DhashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author：xiaoyu
 * @create： 13:15 2019/5/11
 * @description:
 */
@Controller
@RequestMapping("/back")
public class ImageController {
    @Autowired
    DhashService dhashService;
    @Autowired
    ImageService imageService;
    @Autowired
    UrlImageService urlImageService;
    @Autowired
    UserUploadLogService userUploadLogService;
    @Autowired
    UserService userService;
    @RequestMapping("/processImageUrl")
    public ResponseEntity processImageUrl(HttpServletRequest request, @RequestParam("imageUrl") String imageUrl){
        JSONObject jsonObject = new JSONObject();
        try {
            //存入上传记录
            Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
            User user = userService.getUserById(userId);
            UrlImage urlImage = new UrlImage();
            urlImage.setCreateTime(new Date());
            urlImage.setImageUrl(imageUrl);
            urlImage.setUserId(userId);
            userUploadLogService.save(urlImage);
            //获取图片特征值
            String dhashOfImage = dhashService.getDhashOfImage(imageUrl);
            //图像类型匹配
            List<Image> allImages = imageService.getAllImages();
            ArrayList<Image> images = new ArrayList<>();
            Integer minHanm = Integer.MAX_VALUE;
            Image minImage = null;
            for (Image image:allImages){
                Integer hanmDistance = dhashService.getHanmDistance(dhashOfImage, image.getImageDhash());
                if (hanmDistance<=20){
                    image.setHanm(hanmDistance);
                    images.add(image);
                }
                if (hanmDistance<minHanm){
                    minHanm = hanmDistance;
                    minImage = image;
                }
            }
            Image image = new Image();
            image.setUserId(userId);
            image.setImageDhash(dhashOfImage);
            image.setImageName(imageUrl.substring(imageUrl.lastIndexOf("/")));
            image.setImagePath(imageUrl);
            image.setImageType(minImage.getImageType());
            image.setCreateTime(new Date());
            if (minHanm<20){
                //图像类型匹配成功
                imageService.saveImage(image);
                jsonObject.put("result",true);
                jsonObject.put("tImage",images);
            }else {
                //图像类型匹配失败
                urlImageService.saveUrlImage(urlImage);
                jsonObject.put("result",false);
            }
            jsonObject.put("oImage",image);
            jsonObject.put("userName",user.getUserName());
            jsonObject.put("userType",user.getUserType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseEntity responseEntity = new ResponseEntity<>(jsonObject, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/labelImage")
    public ResponseEntity labelImage(HttpServletRequest request, @RequestParam("imageId") Long imageId,@RequestParam("imageType") String imageType) {
        JSONObject jsonObject = new JSONObject();
        try {
            Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
            UrlImage urlImage = urlImageService.findUrlImageById(imageId);
            String imageUrl = urlImage.getImageUrl();
            String dhashOfImage = dhashService.getDhashOfImage(imageUrl);
            Image image = new Image();
            image.setUserId(userId);
            image.setImageDhash(dhashOfImage);
            image.setImageName(imageUrl.substring(imageUrl.lastIndexOf("/")));
            image.setImagePath(imageUrl);
            image.setImageType(imageType);
            image.setCreateTime(new Date());
            imageService.saveImage(image);
            urlImageService.deleteUrlImageById(imageId);
            User user = userService.getUserById(urlImage.getUserId());
            jsonObject.put("image",urlImage);
            jsonObject.put("user",user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseEntity responseEntity = new ResponseEntity<>(jsonObject, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/suyuanImage")
    public ResponseEntity suyuanImage(HttpServletRequest request, @RequestParam("userId") Long userId) {
        List<UrlImage> images = userUploadLogService.findAllByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("images",images);
        ResponseEntity responseEntity = new ResponseEntity<>(jsonObject, HttpStatus.OK);
        return responseEntity;
    }
}
