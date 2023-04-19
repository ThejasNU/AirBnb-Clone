package com._567_606_609.airbnb.services;

import com._567_606_609.airbnb.models.LoginFormData;
import com._567_606_609.airbnb.models.SignUpFormData;
import com._567_606_609.airbnb.models.User;

public interface UserService {
    public String signUp(SignUpFormData signUpFormData);
    public User findUser(Integer id);
    public String login(LoginFormData loginFormData);
}
