package com.example.hito_individual_ad_2ev.application.use_cases;

import com.example.hito_individual_ad_2ev.application.use_cases.ports.UserDbOperator;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.LoginDto;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RequestSimpleResponse;
import com.example.hito_individual_ad_2ev.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUser {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDbOperator userDbOperator;

    public RequestSimpleResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password()));
        var user = userDbOperator.findByEmail(loginDto.email());
        var token = jwtService.generateToken(user);
        return new RequestSimpleResponse(token);
    }
}
