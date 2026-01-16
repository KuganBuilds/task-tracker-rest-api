package com.kuganBuilds.TaskTracker.dto;

import com.kuganBuilds.TaskTracker.entity.TaskPriority;
import com.kuganBuilds.TaskTracker.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
