package com.cfs.csrfDemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CsrfController {

    private Map<String,String> userData = new HashMap<>();

    @GetMapping("/public")
    public String Public()
    {
        return"this is public method";
    }

    @PostMapping("/addUser")
    public Map addUser(@RequestBody Map<String,String> data)
    {
        userData.put(data.get("username"),data.get("password"));
        return userData;
    }
}
