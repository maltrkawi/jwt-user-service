package com.maltrkawi.userservice.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class CustomJwtDsl extends AbstractHttpConfigurer<CustomJwtDsl, HttpSecurity> {

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
        builder.addFilter(new CustomAuthenticationFilter(authenticationManager));
    }

    public static CustomJwtDsl customJwtDsl(){
        return new CustomJwtDsl();
    }
}
