package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.AuthRequest;
import com.cfs.BookMyShow.dto.AuthResponse;
import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto dto) {
        return authService.register(dto);
    }
}