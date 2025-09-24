package org.example.todo_list.controller;

import org.example.todo_list.entity.Task;
import org.example.todo_list.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // 프론트 허용
@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 할일 추가
    @PostMapping("/tasks/{username}")
    public Task addTask(@PathVariable String username, @RequestBody Task task) {
        return taskService.addTask(username, task);
    }

    // 할일 조회
    @GetMapping("/tasks/{username}")
    public List<Task> getTasks(@PathVariable String username) {
        return taskService.getTasks(username);
    }
}
