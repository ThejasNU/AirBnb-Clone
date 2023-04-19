package com._567_606_609.airbnb.repository;

import com._567_606_609.airbnb.models.SignUpFormData;
import com._567_606_609.airbnb.models.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserRepository {

    Integer addUser(SignUpFormData signUpFormData);

    User findUser(Integer id);

    Integer findByEmailAndPassword(String email,String password);
}
