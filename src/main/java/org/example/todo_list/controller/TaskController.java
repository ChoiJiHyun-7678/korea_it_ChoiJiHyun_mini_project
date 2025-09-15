package org.example.todo_list.controller;

import org.example.todo_list.entity.Task;
import org.example.todo_list.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) { this.taskService = taskService; }

    @GetMapping("/tasks/{username}")
    public List<Task> getTasks(@PathVariable String username) {
        return taskService.getTasks(username);
    }

    @PostMapping("/tasks/{username}")
    public Task addTask(@PathVariable String username, @RequestBody Task task) {
        return taskService.addTask(username, task.getContent());
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.updateTask(id, task.getContent(), task.isCompleted());
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id) ? "삭제 성공" : "삭제 실패";
    }
}

