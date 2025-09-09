package org.example.todo_list.controller;

import org.example.todo_list.entity.User;
import org.example.todo_list.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository = new UserRepository();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userRepository.save(user) ? "회원가입 성공" : "이미 존재하는 사용자";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userRepository.validate(user.getUsername(), user.getPassword())
                ? "로그인 성공"
                : "아이디 또는 비밀번호 오류";
    }
}


