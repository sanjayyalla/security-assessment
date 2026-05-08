package com.security.service.impl;

import com.security.service.UserService;
import com.security.user.UserLoginForm;
import com.security.user.UserProfile;
import com.security.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserProfile> userData = new HashMap<>();

    @Override
    public String register(UserProfile userProfile) {
        userData.put(userProfile.getUsername(), userProfile);
        return "User registered";
    }

    @Override
    public String login(UserLoginForm userLoginForm) {

        UserProfile user = userData.get(userLoginForm.getUsername());
        if (user != null) {
            if (userLoginForm.getPassword().equals(user.getPassword())) {
                String token = JwtUtil.generateToken(userLoginForm.getUsername(), user.getRole());
                return token;
            }
        }
        return "User not found";
    }
}
