package com.jocata.service;

import com.jocata.user.UserLoginForm;
import com.jocata.user.UserProfile;

public interface UserService {

    String register(UserProfile userProfile);

    String login(UserLoginForm userLoginForm);
}
