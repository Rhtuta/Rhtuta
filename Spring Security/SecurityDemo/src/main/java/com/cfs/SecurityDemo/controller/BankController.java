package com.cfs.SecurityDemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bal")
public class BankController {

    private int bal=1000;
    @GetMapping
    public int getBalance(){
        return bal;
    }

    @PostMapping("/add")
    public int updateBalance(@RequestParam String accountNo, @RequestParam int amount){
        return bal + amount;
    }

    @GetMapping("/contactUs")
    public String getContact(){
        return "you can contact us at 9633262846";
    }
}
