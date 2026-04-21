package com.cfs.SecurityP02.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth
                .requestMatchers("/","/contactUs","/about").permitAll()
                .requestMatchers("/transfer","/admin").authenticated()
                 )
               // .formLogin(Customizer.withDefaults());
                .httpBasic(Customizer.withDefaults());//for postman http request

        return http.build();
    }
}
