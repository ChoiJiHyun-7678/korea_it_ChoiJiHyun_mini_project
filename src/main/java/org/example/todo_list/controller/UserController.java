package org.example.todo_list.controller;

import org.example.todo_list.entity.User;
import org.example.todo_list.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "회원가입 성공";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.validateLogin(user.getUsername(), user.getPassword())
                ? "로그인 성공"
                : "아이디 또는 비밀번호 오류";
    }
}



