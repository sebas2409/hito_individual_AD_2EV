package com.example.hito_individual_ad_2ev.application.use_cases.ports;

import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskStatusRequest;
import org.springframework.stereotype.Service;

@Service
public interface TaskDbOperator {

    String changeTaskStatus(TaskStatusRequest taskDto);
    String createTask(TaskDto task);
}
