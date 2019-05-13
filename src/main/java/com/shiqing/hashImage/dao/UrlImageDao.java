package com.shiqing.hashImage.dao;

import com.shiqing.hashImage.bean.UrlImage;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author：xiaoyu
 * @create： 15:10 2019/5/11
 * @description:
 */
@Mapper
public interface UrlImageDao {
    /**
     * @param userId
     * @return
     */
    @Results(id = "urlImage",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "imageUrl", column = "imageUrl"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "userId", column = "user_id")
    })
    @Select("select * from url_image where user_id=#{userId}")
    List<UrlImage> findAllByUserId(@Param("userId") Long userId);

    /**
     * @param id
     * @return
     */
    @ResultMap("urlImage")
    @Select("select * from url_image where id=#{id}")
    UrlImage findUrlImageById(@Param("id") Long id);

    /**
     * @param image
     */
    @Insert("insert in to url_image(imageUrl,create_time,user_id)" +
            " values(#{image.imageUrl},#{image.createTime},#{image.userId})")
    void save(@Param("image") UrlImage image);

    /**
     * @param id
     */
    @Delete("delete from url_image where id=#{id}")
    void deleteUrlImageById(@Param("id") Long id);
}
