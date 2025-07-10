package com.jocata.service.impl;

import com.jocata.service.UserService;
import com.jocata.user.UserLoginForm;
import com.jocata.user.UserProfile;
import com.jocata.util.JwtUtil;
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
