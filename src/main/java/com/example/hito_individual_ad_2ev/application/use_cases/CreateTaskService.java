package com.example.hito_individual_ad_2ev.application.use_cases;

import com.example.hito_individual_ad_2ev.application.use_cases.ports.TaskDbOperator;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskService {

    private final TaskDbOperator taskDbOperator;

    public String createTask(TaskDto task) {
        return taskDbOperator.createTask(task);
    }
}
