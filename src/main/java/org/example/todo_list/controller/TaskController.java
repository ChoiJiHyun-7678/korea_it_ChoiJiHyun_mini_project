package org.example.todo_list.controller;

import org.example.todo_list.entity.Task;
import org.example.todo_list.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskRepository taskRepository = new TaskRepository();

    @PostMapping("/add")
    public Task addTask(@RequestBody String title) {
        return taskRepository.addTask(title);
    }

    @GetMapping("/all")
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable int id) {
        taskRepository.completeTask(id);
        return "완료 처리됨";
    };
}

