package com.shiqing.hashImage.controller;

import com.alibaba.fastjson.JSONObject;
import com.shiqing.hashImage.bean.UrlImage;
import com.shiqing.hashImage.bean.User;
import com.shiqing.hashImage.service.UserService;
import com.shiqing.hashImage.service.UserUploadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author：xiaoyu
 * @create： 12:14 2019/5/11
 * @description:
 */
@Controller
@RequestMapping("/back")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserUploadLogService userUploadLogService;

    @RequestMapping("/user")
    @ResponseBody
    public ResponseEntity<User> getUser(@RequestParam("userId") Long userId){
        User user = userService.getUserById(userId);
        List<UrlImage> userImages = userUploadLogService.findAllByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        jsonObject.put("urlImages",userImages);
        ResponseEntity responseEntity = new ResponseEntity<>(jsonObject, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/users")
    @ResponseBody
    public ResponseEntity<User> getUsers(){
        JSONObject jsonObject = new JSONObject();
        List<User> users = userService.getAllUsers();
        jsonObject.put("users",users);
        ResponseEntity responseEntity = new ResponseEntity<>(jsonObject, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity login(HttpServletRequest request,User user){
        User userByName = userService.getUserByName(user.getUserName());
        String password1 = userByName.getPassword();
        if (user.getPassword().equals(password1) && user.getUserType().equals(userByName.getUserType())){
            request.getSession().setAttribute("userId", userByName.getId());
            //登录成功
            return ResponseEntity.ok(1);
        }else {
            //登录失败
            return ResponseEntity.ok(0);
        }
    }

    @RequestMapping("register")
    @ResponseBody
    public ResponseEntity register(HttpServletRequest request, @RequestParam("userName")String userName,@RequestParam("password") String password){
        User userByName = userService.getUserByName(userName);
        if (userByName==null){
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            userService.saveUser(user);
            return ResponseEntity.ok("注册成功");
        }else {
            //用户名已存在
            return ResponseEntity.ok("用户名已存在");
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public ResponseEntity logout(HttpServletRequest request){
        request.getSession().setAttribute("userId",null);
        return ResponseEntity.ok("退出登录成功");
    }
}
