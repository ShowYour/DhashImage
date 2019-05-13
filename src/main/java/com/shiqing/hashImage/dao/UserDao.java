package com.shiqing.hashImage.dao;

import com.shiqing.hashImage.bean.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


/**
 * @author：xiaoyu
 * @create： 11:46 2019/5/11
 * @description:
 */
@Mapper
public interface UserDao {
    /**
     * @param name the name
     * @return the user
     */
    @Select("SELECT * FROM user where user_name=#{name}")
    @Results(id = "user",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userType", column = "user_type")
    })
    User findByUserName(@Param("name") String name);
    /**
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("user")
    User findById(@Param("id")Long id);

    /**
     * @param user
     */
    @Insert("insert into user(password,userName,userType) " +
            "values(#{user.password},#{user.user_name},#{user.user_type})")
    void save(@Param("user") User user);

    /**
     * @return
     */
    @Select("select * from user")
    @ResultMap("user")
    List<User> getAllUsers();
}
