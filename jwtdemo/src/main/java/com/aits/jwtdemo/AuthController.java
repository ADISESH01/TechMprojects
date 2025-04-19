package com.aits.jwtdemo;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
@RestController

@RequestMapping("/auth")

public class AuthController {

    private final JwtUtil jwtUtil;
 
    public AuthController(JwtUtil jwtUtil) {

        this.jwtUtil = jwtUtil;

    }
 
    @PostMapping("/login")

    public AuthResponse login(@RequestBody AuthRequest request) {

        // Hardcoded User Validation (Replace with DB validation)

        if ("admin".equals(request.getUsername()) && "password".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());

            return new AuthResponse(token);

        } else {

            throw new RuntimeException("Invalid credentials");

        }  


        //In general you have to deleagate the request to AuthenticationManager 

    }

}
 
 