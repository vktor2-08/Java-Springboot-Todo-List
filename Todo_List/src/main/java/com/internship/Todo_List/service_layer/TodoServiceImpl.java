package com.internship.Todo_List.service_layer;

import com.internship.Todo_List.models.TodoTask;
import com.internship.Todo_List.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepo todoRepo;

    public TodoServiceImpl(TodoRepo todoRepository) {
        this.todoRepo = todoRepository;
    }

    @Override
    public TodoTask createTodo(TodoTask todoTask) {
        todoTask.setCreatedAt(LocalDateTime.now()); // Set createdAt to the current time
        todoTask.setDone(false); // Default to not done
        return todoRepo.save(todoTask);
    }

    @Override
    public List<TodoTask> getAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public TodoTask getTodoById(Long id) {
        Optional<TodoTask> optionalTodo = todoRepo.findById(id);
        return optionalTodo.orElse(null); // Return null if not found
    }

    @Override
    public TodoTask updateTodo(Long id, TodoTask todoTask) {
        if (todoRepo.existsById(id)) {
            todoTask.setId(id); // Set the ID to ensure the correct entity is updated
            return todoRepo.save(todoTask);
        }
        return null; // Return null if not found
    }

    @Override
    public boolean deleteTodo(Long id) {
        if (todoRepo.existsById(id)) {
            todoRepo.deleteById(id);
            return true; // Return true if deletion was successful
        }
        return false; // Return false if not found
    }
}