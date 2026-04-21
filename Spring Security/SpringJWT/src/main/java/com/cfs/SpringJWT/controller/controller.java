package com.cfs.SpringJWT.controller;

import com.cfs.SpringJWT.util.JwtUtil;
import io.jsonwebtoken.JwtBuilder;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/generate-token")
    public String generateToken(@RequestParam String username, @RequestParam String password){
        if ("admin".equals(username) && "admin".equals(password))
        {
            return jwtUtil.generateToken(username);
        }
        else
        {
            return "Invalid credentials";
        }
    }

    @PostMapping("/fund")
    public String fundTransfer(@RequestHeader(value = "Authorization",required = false) String authorizationHeader){
        if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
        {
            String token = authorizationHeader.substring(7);
            if (jwtUtil.validateToken(token))
            {
                return "this is secure api, valid token";
            }
            else
            {
                return "invalid token";
            }
        }
        else
        {
            return "authorization header is missing";
        }
    }
}
