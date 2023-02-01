package com.example.hito_individual_ad_2ev.application.use_cases.ports;

import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDbOperator {

    String registerUser(User user);
    User findByEmail(String email);

}
