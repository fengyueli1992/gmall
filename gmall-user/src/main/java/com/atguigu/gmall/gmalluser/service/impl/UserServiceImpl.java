package com.atguigu.gmall.gmalluser.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;


import com.atguigu.gmall.gmalluser.mapper.UserAddressMapper;
import com.atguigu.gmall.gmalluser.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


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
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        System.out.println(i+"----00000--------");

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId("1");
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
//        UserInfo userInfo=new UserInfo();
//        userInfo.setId(userId);
       // UserInfo userInfo1 = userInfoMapper.selectOne(userInfo);
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo);
        return userInfo1;

    }

    @Override
    public void delete(String id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("2");
        userInfoMapper.delete(userInfo);
    }
}
