package com.example.progresspal.controller;
import org.springframework.security.core.Authentication;
import com.example.progresspal.model.Users;
import com.example.progresspal.service.UserService;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true"
)
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {

        return userService.registerUser(user);

    }
}