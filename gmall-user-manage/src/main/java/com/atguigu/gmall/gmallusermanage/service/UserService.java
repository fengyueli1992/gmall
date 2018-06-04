package com.atguigu.gmall.gmallusermanage.service;

import com.atguigu.gmall.gmallusermanage.bean.UserAddress;
import com.atguigu.gmall.gmallusermanage.bean.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getUserInfoListAll();

    public void addUser(UserInfo userInfo);

    public void updateUser(String id,UserInfo userInfo);
    public void updateUser(UserInfo userInfo);
    public List<UserAddress> getUserAddressList(String userId);

    public UserInfo login(UserInfo userInfo);

    public UserInfo verify(String userId);


}
