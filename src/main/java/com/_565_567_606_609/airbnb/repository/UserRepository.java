package com._565_567_606_609.airbnb.repository;

import com._565_567_606_609.airbnb.models.SignUpFormData;
import com._565_567_606_609.airbnb.models.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {

    Integer addUser(SignUpFormData signUpFormData);

    User findUser(Integer id);

    Integer findByEmailAndPassword(String email,String password);
}
