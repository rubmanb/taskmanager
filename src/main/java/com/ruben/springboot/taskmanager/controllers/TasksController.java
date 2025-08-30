package com.ruben.springboot.taskmanager.controllers;

import com.ruben.springboot.taskmanager.dto.TasksDto;
import com.ruben.springboot.taskmanager.entities.Task;
import com.ruben.springboot.taskmanager.services.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TasksController {
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TasksDto> listTasks(){
        return taskService.listTask();
    }

    @GetMapping("/{id}")
    public TasksDto getTask(@PathVariable Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping
    public ResponseEntity<TasksDto> createTask(@RequestBody @Valid TasksDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TasksDto updateTask(@PathVariable Long id, @RequestBody @Valid TasksDto taskDto){
        return taskService.updateTask(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTask(@PathVariable Long id){
        taskService.removeTask(id);
        return ResponseEntity.noContent().build();
    }
}
