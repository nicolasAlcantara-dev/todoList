package com.example.todoList.service;

import com.example.todoList.Model.Todo;
import com.example.todoList.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo getById(Long id) {
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> readTodo() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo, Long id) {
        Todo todoExist = todoRepository.findById(id).orElseThrow();
        todoExist.setTitle(todoExist.getTitle());
        todoExist.setCompleted(todo.isCompleted());
        todoRepository.save(todoExist);
        return todoExist;
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
