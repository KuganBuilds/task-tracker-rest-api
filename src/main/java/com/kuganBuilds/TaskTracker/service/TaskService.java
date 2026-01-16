package com.kuganBuilds.TaskTracker.service;

import com.kuganBuilds.TaskTracker.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id,Task updatedTask);

    void deleteTask(Long id);
}
