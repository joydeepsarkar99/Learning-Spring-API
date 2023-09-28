package com.acciojob.firstapiproject;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class RepositoryLayer {

    HashMap<Integer,UserInfo> userInfoDB = new HashMap<>();

    public String addUsers(UserInfo obj){
        int key = obj.getUserId();
        userInfoDB.put(key,obj);
        return "user added to the DB using CRS";
    }

    public List<UserInfo> findAllUsersList(){
        return userInfoDB.values().stream().toList();
    }
}
