package org.example.todo_list.controller;

import org.example.todo_list.entity.User;
import org.example.todo_list.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
}
