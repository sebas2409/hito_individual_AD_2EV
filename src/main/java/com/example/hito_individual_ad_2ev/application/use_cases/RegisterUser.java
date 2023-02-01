package com.example.hito_individual_ad_2ev.application.use_cases;

import com.example.hito_individual_ad_2ev.application.mapper.DtoToEntityConverter;
import com.example.hito_individual_ad_2ev.application.use_cases.ports.UserDbOperator;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RegisterResponse;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUser {
    private final UserDbOperator userDbOperator;
    private final DtoToEntityConverter dtoToEntityConverter;

    public RegisterResponse registerUser(RegisterDto registerDto) {
        var user = dtoToEntityConverter.apply(registerDto);
        var response = userDbOperator.registerUser(user);
        return new RegisterResponse(response);
    }


}
