package org.example.todo_list.service;

import org.example.todo_list.entity.Task;
import org.example.todo_list.entity.User;
import org.example.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> getTasks(String username) {
        User user = userService.getUser(username);
        return taskRepository.findByUser(user);
    }

    public Task addTask(String username, String content) {
        User user = userService.getUser(username);
        Task task = new Task();
        task.setUser(user);
        task.setContent(content);
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, String content, Boolean completed) {
        Task task = taskRepository.findById(id).orElse(null);
        if(task != null) {
            if(content != null) task.setContent(content);
            if(completed != null) task.setCompleted(completed);
            taskRepository.save(task);
        }
        return task;
    }

    public boolean deleteTask(Integer id) {
        if(taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
