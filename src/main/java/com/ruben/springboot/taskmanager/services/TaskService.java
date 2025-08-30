package com.ruben.springboot.taskmanager.services;

import com.ruben.springboot.taskmanager.dto.TasksDto;

import java.util.List;

public interface TaskService {

    List<TasksDto> listTask();
    TasksDto findTaskById(Long id);
    TasksDto createTask(TasksDto taskDTO);
    TasksDto updateTask(Long id, TasksDto taskDto);
    void removeTask(Long id);
}
