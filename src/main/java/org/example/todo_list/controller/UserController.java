package org.example.todo_list.controller;

import org.example.todo_list.entity.User;
import org.example.todo_list.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173") // 프론트 허용
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok(Map.of("message", "회원가입 성공"));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean ok = userService.validateLogin(user.getUsername(), user.getPassword());
        if (ok) {
            User found = userService.findByUsername(user.getUsername());
            return ResponseEntity.ok(Map.of(
                    "message", "로그인 성공",
                    "username", found.getUsername(),
                    "userId", found.getId()
            ));
        } else {
            return ResponseEntity.status(401)
                    .body(Map.of("message", "아이디 또는 비밀번호 오류"));
        }
    }
}
