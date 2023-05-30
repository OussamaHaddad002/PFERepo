package com.satoripop.com.service;

import com.satoripop.com.model.UserInfo;
import com.satoripop.com.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfo> getUserInfos() {
        List<UserInfo> userInfos = new ArrayList<>();
        userInfoRepository.findAll().forEach(
                userInfo -> {
                    userInfos.add(userInfo);
                }

        );
        return userInfos;
    }

    public void addUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public void update(UserInfo userInfo, long id){
        userInfoRepository.save(userInfo);
    }

    public UserInfo getUserInfoById(long id){
        return userInfoRepository.findById(id).orElse(null);
    }

    public void deleteUserInfo(long id) {
        userInfoRepository.deleteById(id);
    }
}
