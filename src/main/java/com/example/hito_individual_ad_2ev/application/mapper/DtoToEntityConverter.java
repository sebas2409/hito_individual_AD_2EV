package com.example.hito_individual_ad_2ev.application.mapper;

import com.example.hito_individual_ad_2ev.domain.Role;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RegisterDto;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class DtoToEntityConverter implements Function<RegisterDto, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User apply(RegisterDto registerDto) {
        return User.builder()
                .name(registerDto.name())
                .email(registerDto.email())
                .pass(passwordEncoder.encode(registerDto.password()))
                .role(Role.USER.toString())
                .build();
    }
}
