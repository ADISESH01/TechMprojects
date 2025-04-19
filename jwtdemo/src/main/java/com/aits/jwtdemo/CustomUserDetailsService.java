package com.aits.jwtdemo;



import java.util.Collections;
 
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
 
 
//To load the username and password from db..verify

@Service  

public class CustomUserDetailsService implements UserDetailsService {
 
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!"admin".equals(username)) {

            throw new UsernameNotFoundException("User not found");

        }
 
        return new User(

            "admin",

            new BCryptPasswordEncoder().encode("password"), // Store encrypted passwords

            Collections.emptyList()

        );

    }


    //in general you will get the data of username from db

}

 