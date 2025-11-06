package com.example.todoList.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    private boolean completed;

    public Todo() {
    }
}
