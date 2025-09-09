package org.example.todo_list.repository;

import org.example.todo_list.entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int currentId = 1;

    public Task addTask(String title) {
        Task task = new Task(currentId++, title);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void completeTask(int id) {
        for(Task t : tasks) {
            if(t.getId() == id) {
                t.setCompleted(true);
                break;
            }
        }
    }
}
