package com.satoripop.com.controller;

import com.satoripop.com.model.UserInfo;
import com.satoripop.com.model.enumeration.Status;
import com.satoripop.com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/userInfos")
    public List<UserInfo> getUserInfos(){
        return userInfoService.getUserInfos();
    }

    @RequestMapping("/userInfo")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo(1L,"Me","Me",12,14);
        return userInfo;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/userInfo/{id}")
    public UserInfo getUserInfoById(@PathVariable long id){
        return userInfoService.getUserInfoById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/userInfo/{id}")
    public void deleteUserInfo(@PathVariable long id){
        userInfoService.deleteUserInfo(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/userInfos")
    public void addUserInfo(@RequestBody UserInfo UserInfo){
        userInfoService.addUserInfo(UserInfo);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/userInfo/{id}")
    public void updateUserInfo(@RequestBody UserInfo UserInfo,@PathVariable long id){
        userInfoService.update(UserInfo,id);
    }
}
