package com.example.hito_individual_ad_2ev.infrastructure.controller;

import com.example.hito_individual_ad_2ev.application.use_cases.ChangeTaskStatus;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RequestSimpleResponse;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final ChangeTaskStatus changeTaskStatus;

    @PostMapping("/changeTaskStatus")
    public ResponseEntity<RequestSimpleResponse> changeTaskStatus(@RequestBody TaskStatusRequest taskDto) {
        var rs = changeTaskStatus.changeTaskStatus(taskDto);
        return ResponseEntity.ok(new RequestSimpleResponse(rs));
    }


}
