package com.example.hito_individual_ad_2ev.infrastructure.controller;

import com.example.hito_individual_ad_2ev.application.use_cases.LoginUser;
import com.example.hito_individual_ad_2ev.application.use_cases.RegisterUser;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.LoginDto;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RequestSimpleResponse;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final RegisterUser registerUser;
    private final LoginUser loginUser;

    @PostMapping("/register")
    public ResponseEntity<RequestSimpleResponse> registerUser(@RequestBody RegisterDto registerDto) {
        var response = registerUser.registerUser(registerDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<RequestSimpleResponse> loginUser(@RequestBody LoginDto loginDto) {
        var response = loginUser.login(loginDto);
        return ResponseEntity.ok(response);
    }


}
