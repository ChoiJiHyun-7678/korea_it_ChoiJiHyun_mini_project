package org.example.todo_list.repository;

import org.example.todo_list.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public boolean save(User user) {
        for(User u : users) {
            if(u.getUsername().equals(user.getUsername())) return false; // 중복 방지
        }
        users.add(user);
        return true;
    }

    public boolean validate(String username, String password) {
        for(User u : users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) return true;
        }
        return false;
    }
}
