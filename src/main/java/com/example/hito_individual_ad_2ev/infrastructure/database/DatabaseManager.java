package com.example.hito_individual_ad_2ev.infrastructure.database;

import com.example.hito_individual_ad_2ev.application.use_cases.ports.UserDbOperator;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseManager implements UserDbOperator {

    private final UserRepository userRepository;

    @Override
    public String registerUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("El usuario ya existe");
                });
        userRepository.save(user);
        return "Usuario registrado correctamente";
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
}
