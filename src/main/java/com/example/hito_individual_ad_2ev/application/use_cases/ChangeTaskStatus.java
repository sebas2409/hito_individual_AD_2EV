package com.example.hito_individual_ad_2ev.application.use_cases;

import com.example.hito_individual_ad_2ev.application.use_cases.ports.TaskDbOperator;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeTaskStatus {

    private final TaskDbOperator taskDbOperator;

    public String changeTaskStatus(TaskStatusRequest taskDto) {
        return taskDbOperator.changeTaskStatus(taskDto);
    }
}
