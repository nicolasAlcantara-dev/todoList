package com.example.todoList.controller;

import com.example.todoList.Model.Todo;
import com.example.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/readTodo")
    public List<Todo> readTodos() {
        return todoService.readTodo();
    }

    @GetMapping("/readTodo/{id}")
    public ResponseEntity<Todo> readTodo(@PathVariable Long id) {
        Todo byId = todoService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping("/createTodo")
    public ResponseEntity<Void> createTodo(@RequestBody Todo todo) {
        todoService.createTodo(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateTodo/{id}")
    public Todo save(@RequestBody Todo todo, @PathVariable Long id) {
        return todoService.updateTodo(todo, id);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
