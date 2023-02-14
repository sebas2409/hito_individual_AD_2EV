package com.example.hito_individual_ad_2ev.infrastructure.database;

import com.example.hito_individual_ad_2ev.application.use_cases.ports.TaskDbOperator;
import com.example.hito_individual_ad_2ev.application.use_cases.ports.UserDbOperator;
import com.example.hito_individual_ad_2ev.domain.TaskStatus;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskDto;
import com.example.hito_individual_ad_2ev.infrastructure.controller.dto.TaskStatusRequest;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.Task;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.TaskRepository;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DatabaseManager implements UserDbOperator, TaskDbOperator {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public String registerUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("El usuario ya existe");
                });
        userRepository.save(user);
        return "Usuario registrado correctamente";
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }

    @Override
    public String changeTaskStatus(TaskStatusRequest taskDto) {
        taskRepository.changeTaskStatus(taskDto.id(), taskDto.status());
        return "Estado de la tarea cambiado correctamente";
    }

    @Override
    public String createTask(TaskDto task) {
        var formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        var user = userRepository.findByEmail(task.user())
                .orElse(null);
        taskRepository.save(new Task(user,
                task.description(),
                LocalDate.parse(task.createdAt(), formatter),
                LocalDate.parse(task.endAt(), formatter),
                task.status().toString()));
        return "Tarea creada correctamente";
    }

}
