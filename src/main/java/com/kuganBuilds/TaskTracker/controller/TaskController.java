package com.kuganBuilds.TaskTracker.controller;

import com.kuganBuilds.TaskTracker.dto.TaskRequestDTO;
import com.kuganBuilds.TaskTracker.dto.TaskResponseDTO;
import com.kuganBuilds.TaskTracker.entity.Task;
import com.kuganBuilds.TaskTracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://192.168.29.215:5505/")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    //create task
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        Task savedTask = taskService.createTask(task);

        TaskResponseDTO response = mapToResponse(savedTask);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // GET ALL TASKS
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {

        List<TaskResponseDTO> response = taskService.getAllTasks()
                .stream()
                .map(this::mapToResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {

        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(mapToResponse(task));
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @PathVariable Long id,
           @Valid @RequestBody TaskRequestDTO request) {

        Task updatedTask = new Task();
        updatedTask.setTitle(request.getTitle());
        updatedTask.setDescription(request.getDescription());
        updatedTask.setStatus(request.getStatus());
        updatedTask.setPriority(request.getPriority());
        updatedTask.setDueDate(request.getDueDate());

        Task task = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(mapToResponse(task));
    }

    // DELETE TASK (SOFT DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // --------- MAPPING METHOD ---------

    private TaskResponseDTO mapToResponse(Task task) {
        TaskResponseDTO response = new TaskResponseDTO();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setPriority(task.getPriority());
        response.setDueDate(task.getDueDate());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        return response;
    }


}
