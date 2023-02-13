package com.example.hito_individual_ad_2ev.infrastructure.controller;

import com.example.hito_individual_ad_2ev.application.use_cases.ChangeTaskStatus;
import com.example.hito_individual_ad_2ev.domain.TaskStatus;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.RequestSimpleResponse;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDtoResponse;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskStatusRequest;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.Task;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.TaskRepository;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    private final ChangeTaskStatus changeTaskStatus;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @PostMapping("/changeTaskStatus")
    public ResponseEntity<RequestSimpleResponse> changeTaskStatus(@RequestBody TaskStatusRequest taskDto) {
        var rs = changeTaskStatus.changeTaskStatus(taskDto);
        return ResponseEntity.ok(new RequestSimpleResponse(rs));
    }

    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskDtoResponse>> getTasks() {
        var rs = taskRepository.findAll();
        var dto =
                rs.stream()
                        .map(t ->
                                new TaskDtoResponse(t.getId(), t.getUser().getEmail(),
                                        t.getDescription(),
                                        t.getCreatedAt().toString(),
                                        t.getEndAt().toString(),
                                        TaskStatus.valueOf(t.getStatus())))
                        .toList();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addTask")
    public ResponseEntity<RequestSimpleResponse> addTask(@RequestBody TaskDto task) {
        var user = userRepository.findByEmail(task.user()).get();
        var taskEntity = new Task(user, task.description(), LocalDate.parse(task.createdAt()), LocalDate.parse(task.endAt()), task.status().toString());
        taskRepository.save(taskEntity);
        return ResponseEntity.ok(new RequestSimpleResponse("Tarea creada correctamente"));
    }


}
