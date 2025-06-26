package com.example.todoList.service;

import com.example.todoList.Model.Todo;
import com.example.todoList.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // 1. Salvar uma nova tarefa
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 2. Encontrar todas as tarefas
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    // 3. Busca tarefa por ID
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    // 4. Atualiza tarefa existente
    public Todo updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setCompleted(todoDetails.isCompleted());
                    return todoRepository.save(existingTodo);
                })
                .orElseThrow(() -> new RuntimeException("Todo não encontrado com id: " + id));
    }

    // 5. Deletar tarefa
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
