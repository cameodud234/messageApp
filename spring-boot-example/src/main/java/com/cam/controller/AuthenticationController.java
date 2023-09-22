package com.cam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cam.security.JwtUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public String authenticate(String username) {
        return jwtUtil.generateToken(username);
    }
}
