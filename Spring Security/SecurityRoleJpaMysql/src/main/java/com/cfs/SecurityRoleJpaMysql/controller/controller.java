package com.cfs.SecurityRoleJpaMysql.controller;

import com.cfs.SecurityRoleJpaMysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private UserService service;

    @PostMapping("/addUsers")
    public String addUsers(@RequestBody ListUserRequests requests)
    {
        service.saveUser(requests.getUsers());
        return "Users added successfully";
    }

    @GetMapping("/public")
    public String Public()
    {
        return "this is public method";
    }

    @GetMapping("/user")
    public String user(){
        return "this is user method";
    }

    @GetMapping("/admin")
    public String admin(){
        return "this is admin method";
    }
}
