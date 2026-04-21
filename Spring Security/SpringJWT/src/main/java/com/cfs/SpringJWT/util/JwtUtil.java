package com.cfs.SpringJWT.util;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.apache.el.parser.Token;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.security.Key;
import java.util.Date;

@Service
public class JwtUtil {

    private final static String SECRET_KEY_STRING="rohit8939#jiojfihifiehiofiohe93992";

    private final Key SECRET_KEY= Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    public String generateToken(String username)
    {
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*3000))
                .signWith(SECRET_KEY)
                .compact();
        System.out.println("token generated: "+ token);
        return token;
    }

    public boolean validateToken(String token){

        try
        {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException e)
        {
            System.out.println("Jwt Expired: "+e.getMessage());
            return false;
        }
        catch (SignatureException e)
        {
            System.out.println("Invalid jwt Signature: "+e.getMessage());
            return false;
        }
        catch (Exception e)
        {
            System.out.println("");
            return false;
        }
    }
}
