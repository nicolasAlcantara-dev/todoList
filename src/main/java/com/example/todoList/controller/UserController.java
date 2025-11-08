package com.example.todoList.controller;

import com.example.todoList.Model.Todo;
import com.example.todoList.Model.User;
import com.example.todoList.Repository.UserRepository;
import com.example.todoList.service.TodoService;
import com.example.todoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
