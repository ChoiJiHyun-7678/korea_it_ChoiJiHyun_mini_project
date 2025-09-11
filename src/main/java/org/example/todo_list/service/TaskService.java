package org.example.todo_list.service;

import org.example.todo_list.entity.User;
import org.example.todo_list.entity.Task;
import org.example.todo_list.repository.UserRepository;
import org.example.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // 회원가입
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // 로그인
    public boolean validateLogin(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    // 할일 추가
    public Task addTask(String username, Task task) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        return taskRepository.save(task);
    }

    // 할일 조회
    public List<Task> getTasks(String username) {
        return taskRepository.findByUserUsername(username);
    }
}
