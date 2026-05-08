package com.security.controller;

import com.security.service.UserService;
import com.security.user.UserLoginForm;
import com.security.user.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserProfile userProfile) {

        if (userProfile.getUsername() != null && !userProfile.getUsername().isEmpty() &&
                userProfile.getPassword() != null && !userProfile.getPassword().isEmpty()
                && userProfile.getRole() != null && !userProfile.getRole().isEmpty()) {
            return userService.register(userProfile);
        }
        return "Please provide all the details";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginForm userLoginForm) {
        if (userLoginForm.getUsername() != null && !userLoginForm.getUsername().isEmpty()
                && userLoginForm.getPassword() != null && !userLoginForm.getPassword().isEmpty()) {
            return ResponseEntity.ok(userService.login(userLoginForm));
        }else{
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}
