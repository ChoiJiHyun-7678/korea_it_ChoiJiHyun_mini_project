package org.example.todo_list.service;

import org.example.todo_list.entity.User;
import org.example.todo_list.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            return "이미 존재하는 사용자";
        }
        userRepository.save(user);
        return "회원가입 성공";
    }

    public String login(User user) {
        User found = userRepository.findByUsername(user.getUsername());
        if(found != null && found.getPassword().equals(user.getPassword())) {
            return "로그인 성공";
        }
        return "아이디 또는 비밀번호 오류";
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
