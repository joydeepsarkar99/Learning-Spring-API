package com.acciojob.firstapiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControllerLayer {

    @Autowired
    ServiceLayer serviceLayerObj;

    @PostMapping("/addUserByRequestBody")
    public ResponseEntity<String> addUserInfoViaRequestBody(@RequestBody UserInfo obj){
        String ans = serviceLayerObj.addUsers(obj);
        return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserInfo>> findAllUserInfo(){
        List<UserInfo> ansList = serviceLayerObj.findAllUsersList();
        return new ResponseEntity<>(ansList,HttpStatus.FOUND);
    }
}
