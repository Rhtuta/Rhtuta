package com.cfs.BookMyShow.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
