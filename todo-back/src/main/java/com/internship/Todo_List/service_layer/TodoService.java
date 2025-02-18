package com.internship.Todo_List.service_layer;

import com.internship.Todo_List.models.TodoTask;
import java.util.List;

public interface TodoService {
    TodoTask createTodo(TodoTask todoTask);
    List<TodoTask> getAllTodos();
    TodoTask getTodoById(Long id);
    TodoTask updateTodo(Long id, TodoTask todoTask);
    boolean deleteTodo(Long id);
}