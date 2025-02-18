package com.internship.Todo_List.controller;

import com.internship.Todo_List.models.TodoTask;
import com.internship.Todo_List.service_layer.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoTask> createTodo(@RequestBody TodoTask todoTask) {
        TodoTask createdTask = todoService.createTodo(todoTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoTask>> getAllTodos() {
        List<TodoTask> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoTask> getTodoById(@PathVariable Long id) {
        TodoTask todoTask = todoService.getTodoById(id);
        if (todoTask != null) {
            return new ResponseEntity<>(todoTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoTask> updateTodo(@PathVariable Long id, @RequestBody TodoTask todoTask) {
        TodoTask updatedTask = todoService.updateTodo(id, todoTask);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if (todoService.deleteTodo(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}