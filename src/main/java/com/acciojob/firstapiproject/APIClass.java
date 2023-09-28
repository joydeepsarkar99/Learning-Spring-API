package com.acciojob.firstapiproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIClass {
    HashMap<Integer,UserInfo> userInfoMapDB = new HashMap<>();

    @PostMapping("/addUser")
    public String addUserInfo(@RequestParam("userId")Integer userId,
                              @RequestParam("name")String name,
                              @RequestParam("age")Integer age,
                              @RequestParam("emailId")String emailId){

        UserInfo userInfo = new UserInfo(userId,name,age,emailId);
        userInfoMapDB.put(userId,userInfo);
        return "user added to the database successfully";
    }

    //implemented using CRS
//    @PostMapping("/addUserByRequestBody")
//    public String addUserInfoViaRequestBody(@RequestBody UserInfo obj){
//        int key = obj.getUserId();
//        userInfoMapDB.put(key,obj);
//        return "user added to the database successfully via Postman JSON obj";
//    }

    @GetMapping("/getUserByUserId")
    public UserInfo getUserByUserInfoDB(@RequestParam("userId")Integer userId){
        UserInfo responseDB = userInfoMapDB.get(userId);
        return responseDB;
    }

    @GetMapping("/getUser/{userId}")
    public UserInfo getUserByUserId(@PathVariable("userId")Integer userId){
        UserInfo obj = userInfoMapDB.get(userId);
        return obj;
    }

    @GetMapping("getUser/{ageGreaterThan}/{ageLessThan}")
    public List<UserInfo> getUserByAge(@PathVariable("ageGreaterThan") Integer ageGreaterThan,
                                       @PathVariable("ageLessThan")Integer ageLessThan){

        List<UserInfo> ansList = new ArrayList<>();
        for(UserInfo obj : userInfoMapDB.values()){
            if(obj.getAge() >= ageGreaterThan && obj.getAge() <= ageLessThan){
                ansList.add(obj);
            }
        }
        return ansList;
    }

    //implemented using CRS
//    @GetMapping("/findAllUsers")
//    public List<UserInfo> findAllUserInfo(){
//        //we could have directly returned them as well like a shortcut
//        // return userInfoMapDB.values().stream().toList();
//
//        List<UserInfo> userInfoList = new ArrayList<>();
//        for(UserInfo obj : userInfoMapDB.values()){
//            userInfoList.add(obj);
//        }
//        return userInfoList;
//    }

    @GetMapping("/findOnlyName")
    public List<String> getNameOfRegisteredPeople(){
        List<String> userNameList = new ArrayList<>();
        for(UserInfo obj : userInfoMapDB.values()){
            userNameList.add(obj.getName());
        }
        return userNameList;
    }

    @GetMapping("/welcome")
    public String welcomeResponse(){
        return "Welcome to the first API Project";
    }

    @GetMapping("/about")
    public String aboutResponse(){
        return "API is a Application Programming Interface";
    }

}
