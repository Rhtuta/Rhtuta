package com.cfs.BookMyShow.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {

    public static String getLoggedInUserEmail() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }
}