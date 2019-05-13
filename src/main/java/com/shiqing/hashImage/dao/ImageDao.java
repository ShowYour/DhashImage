package com.shiqing.hashImage.dao;

import com.shiqing.hashImage.bean.Image;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author：xiaoyu
 * @create： 14:56 2019/5/11
 * @description:
 */
@Mapper
public interface ImageDao {


    /**
     * @param userId
     * @return
     */
    @Results(id="image",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "imageName", column = "image_name"),
            @Result(property = "imagePath", column = "image_path"),
            @Result(property = "imageDhash", column = "image_dhash"),
            @Result(property = "imageType", column = "image_type"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "userId", column = "user_id")
    })
    @Select("select * from image where user_id = #{userId}")
    List<Image> findAllByUserId(@Param("userId") Long userId);


    /**
     * @return
     */
    @ResultMap("image")
    @Select("select * from image")
    List<Image> getAllImages();
    /**
     * @param imageDhash
     * @return
     */
    @ResultMap("image")
    @Select("select * from image where image_hash=#{imageDhash}")
    Image findByImageDhash(@Param("imageDhash") String imageDhash);

    /**
     * @param image
     */
    @Insert("insert in to image(image_name,image_path,image_dhash,image_type,create_time,user_id)" +
            " values(#{image.imageName},#{image.imagePath},#{image.imageDhash},#{image.imageType},#{image.createTime},#{image.userId})")
    void save(@Param("image") Image image);
}
