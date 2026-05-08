package com.security.service;

import com.security.user.UserLoginForm;
import com.security.user.UserProfile;

public interface UserService {

    String register(UserProfile userProfile);

    String login(UserLoginForm userLoginForm);
}
