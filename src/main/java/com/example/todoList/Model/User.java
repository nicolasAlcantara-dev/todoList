package com.example.todoList.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    // RELACIONAMENTO: Um usuário pode ter várias TODOs
    @OneToMany(mappedBy = "user")
    private List<Todo> todos = new ArrayList<>();


    // Métodos auxiliares para gerenciar o relacionamento
    public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setUser(this);
    }

}
