package com.cfs.SecurityP03_Role.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public String getBalance()
    {
        return "your balance is 800000";
    }

    public String getClose()
    {
        return "your account is close";
    }

    public String getAbout(){
        return "roles in spring security is implemented";
    }
}
