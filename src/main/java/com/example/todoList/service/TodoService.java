package com.example.todoList.service;

import com.example.todoList.Model.Todo;
import com.example.todoList.Model.User;
import com.example.todoList.Repository.TodoRepository;
import com.example.todoList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodoForUser(Long userId, Todo todo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Associa o todo ao usuário
        user.addTodo(todo);
        return todoRepository.save(todo);
    }

    public List<Todo> getUserTodos(Long userId) {
        return todoRepository.findByUserId(userId);
    }
}
