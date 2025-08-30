package com.ruben.springboot.taskmanager.services.impl;

import com.ruben.springboot.taskmanager.dto.TasksDto;
import com.ruben.springboot.taskmanager.entities.Task;
import com.ruben.springboot.taskmanager.exception.ResourceNotFoundException;
import com.ruben.springboot.taskmanager.repositories.TaskRepository;
import com.ruben.springboot.taskmanager.services.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TasksDto> listTask() {
        return taskRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public TasksDto findTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Task not found"));
        return mapToDTO(task);
    }

    @Override
    public TasksDto createTask(TasksDto taskDTO) {
        Task task = mapToEntity(taskDTO);
        return mapToDTO(taskRepository.save(task));
    }

    @Override
    public TasksDto updateTask(Long id, TasksDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        return mapToDTO(taskRepository.save(task));
    }

    @Override
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TasksDto mapToDTO(Task task) {
        TasksDto dto = new TasksDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        return dto;
    }

    private Task mapToEntity(TasksDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return task;
    }
}
