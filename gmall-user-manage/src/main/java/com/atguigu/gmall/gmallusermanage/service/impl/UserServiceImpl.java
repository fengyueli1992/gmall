package com.atguigu.gmall.gmallusermanage.service.impl;

import com.atguigu.gmall.gmallusermanage.bean.UserAddress;
import com.atguigu.gmall.gmallusermanage.bean.UserInfo;
import com.atguigu.gmall.gmallusermanage.mapper.UserAddressMapper;
import com.atguigu.gmall.gmallusermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.gmallusermanage.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);

    }

    @Override
    public void updateUser(String id, UserInfo userInfo) {
        userInfo.setId(id);
        int i = userInfoMapper.updateByPrimaryKey(userInfo);
        System.out.print(i+"------------");

    }
    @Override
    public void updateUser(UserInfo userInfo) {

        int i = userInfoMapper.updateByPrimaryKey(userInfo);
        System.out.println(i+"----00000--------");

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId(Integer.parseInt(userId));
        List<UserAddress> listUserAddress= userAddressMapper.select(userAddress);
        return listUserAddress;
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoMapper.selectOne(userInfo);
        return userInfo1;
    }

    @Override
    public UserInfo verify(String userId) {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        UserInfo userInfo1 = userInfoMapper.selectOne(userInfo);
        return userInfo1;

    }
}
