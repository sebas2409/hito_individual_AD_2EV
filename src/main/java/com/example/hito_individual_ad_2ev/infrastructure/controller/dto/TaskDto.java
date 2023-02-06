package com.example.hito_individual_ad_2ev.infrastructure.controller.dto;

import com.example.hito_individual_ad_2ev.domain.TaskStatus;

public record TaskDto(UserCompleteDto user, String description, String createdAt, String endAt, TaskStatus status) {
}
