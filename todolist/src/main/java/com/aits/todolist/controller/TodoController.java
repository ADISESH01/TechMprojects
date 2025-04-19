package com.aits.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aits.todolist.Todo;
import com.aits.todolist.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // Create a new Todo (POST)
    @PostMapping
    public Todo insert(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // Get all Todos (GET)
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Update an existing Todo (PUT)
    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo); // assumes Todo contains an ID for update
    }
}
