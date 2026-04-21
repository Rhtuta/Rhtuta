package com.cfs.SecurityP02.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BankController {

    @GetMapping("/contactUs")
    public String getContact(){
        return "you can contact us at 9633262846";
    }

    @GetMapping("/about")
    public String about(){
        return "Rohit founder of this about api";
    }
    @GetMapping("/transfer")
    public String transfer(){
        return "Amount transferred successfully";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin api";
    }


}
