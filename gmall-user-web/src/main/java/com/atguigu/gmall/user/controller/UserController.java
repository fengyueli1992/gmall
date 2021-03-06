package com.atguigu.gmall.user.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Reference
    private UserService userService;

    @RequestMapping("/userList")
    public ResponseEntity<List<UserInfo>> userList(){
        List<UserInfo> userInfoListAll = userService.getUserInfoListAll();
        return ResponseEntity.ok(userInfoListAll);
    }

    @RequestMapping("addUserInfo")
    public void addUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setName("tom");
        userInfo.setNickName("tomee");
        userService.addUser(userInfo);
    }
    @RequestMapping("updateUserInfo")
    public void updateUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId("3");
        userInfo.setName("tom22");
        userInfo.setNickName("tom122");
        userService.updateUser("2",userInfo);
    }

    @RequestMapping("updateUserInfo1")
    public void updateUserInfo1(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId("3");
        userInfo.setName("tom22");
        userInfo.setNickName("tom122");
        userService.updateUser(userInfo);
    }
    @RequestMapping("login")
    public UserInfo selectUserInfo1(){
         UserInfo userInfo = new UserInfo();
         userInfo.setId("1");
         return userService.login(userInfo);
    }
    @RequestMapping("verfy")
    public UserInfo verfy(){
        return userService.verify("1");
    }
    @RequestMapping("deleteUserInfoById")
    public void deleteUserInfoById(){
        userService.delete("2");
    }
    @RequestMapping("getUserAddressList/{id}")
    public ResponseEntity<List<UserAddress>> getUserAddressList(@PathVariable String id){
        List<UserAddress> userAddressList = userService.getUserAddressList(id);
       return  ResponseEntity.ok(userAddressList);
    }
}
