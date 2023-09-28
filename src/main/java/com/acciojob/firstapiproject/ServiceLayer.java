package com.acciojob.firstapiproject;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    RepositoryLayer repositoryLayerObj;

    public String addUsers(UserInfo obj){
        String ans = repositoryLayerObj.addUsers(obj);
        return ans;
    }
    public List<UserInfo> findAllUsersList(){
        return repositoryLayerObj.findAllUsersList();
    }
}
