package com.example.hito_individual_ad_2ev.infrastructure.controller;

import com.example.hito_individual_ad_2ev.application.use_cases.CreateTaskService;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final CreateTaskService createTaskService;

    @PostMapping("/create_task")
    public ResponseEntity<String> createTask(@RequestBody TaskDto task) {
        var rs = createTaskService.createTask(task);
        return ResponseEntity.ok(rs);
    }




}
