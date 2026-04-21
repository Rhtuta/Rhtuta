package com.cfs.SecurityP03_Role.controller;

import com.cfs.SecurityP03_Role.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private AccountService service;

    @GetMapping("/about")
    public String about()
    {
        return service.getAbout();
    }

    @GetMapping("/balance")
   // @PreAuthorize("isAuthenticated")//by using this , it means
    // it can be accessible by all saved user Roles here like
    // accessible by both USER and ADMIN
    // but authorization is needed due to isAuthentication
    @PreAuthorize("hasRole('USER')")
    public String balance()
    {
        return service.getBalance();
    }

    @GetMapping("/close")
    @PreAuthorize("hasRole('ADMIN')")
    public String close()
    {
        return service.getClose();
    }
}
