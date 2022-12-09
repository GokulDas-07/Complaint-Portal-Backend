package com.nest.complaintportal_backend.controller;

import com.nest.complaintportal_backend.dao.UserDao;
import com.nest.complaintportal_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/user",consumes = "application/json",produces = "application/json")
    public String addUser(@RequestBody User u)
    {
        dao.save(u);
        return ("User registered");
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userLogin(@RequestBody User u)
    {
        System.out.println(u.getMail());
        List<User> result =(List<User>) dao.userLogin(u.getMail(),u.getPassword());
        HashMap<String,String> map = new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
            map.put("message","No user");
        }else{
            int id =result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userinfo",consumes = "application/json",produces = "application/json")
    public List<User> userInfo (@RequestBody User u)
    {
        String id=String.valueOf(u.getId());
        System.out.println(id);
        return (List<User>) dao.userInfo(u.getId());
    }



}
