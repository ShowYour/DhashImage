package com.shiqing.hashImage.dao;

import com.shiqing.hashImage.bean.UrlImage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserUploadLogDao {

    /**
     * @param userId
     * @return
     */
    @Results(id = "urlImage",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "imageUrl", column = "image_url"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "userId", column = "user_id")
    })
    @Select("select * from url_upload_log where user_id=#{userId} order by create_time asc")
    List<UrlImage> findAllByUserId(@Param("userId") Long userId);


    /**
     * @param image
     */
    @Insert("insert in to url_upload_log(imageUrl,create_time,user_id)" +
            " values(#{image.imageUrl},#{image.createTime},#{image.userId})")
    void save(@Param("image") UrlImage image);
}
