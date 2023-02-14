package com.example.hito_individual_ad_2ev.infrastructure.controller;

import com.example.hito_individual_ad_2ev.application.use_cases.CreateTaskService;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final CreateTaskService createTaskService;
    private final UserRepository userRepository;

    @PostMapping("/create_task")
    public ResponseEntity<String> createTask(@RequestBody TaskDto task) {
        var rs = createTaskService.createTask(task);
        return ResponseEntity.ok(rs);
    }


}
