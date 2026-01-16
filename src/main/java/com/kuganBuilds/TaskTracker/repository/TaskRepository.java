package com.kuganBuilds.TaskTracker.repository;

import com.kuganBuilds.TaskTracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {




}
