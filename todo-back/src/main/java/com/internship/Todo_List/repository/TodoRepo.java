package com.internship.Todo_List.repository;

import com.internship.Todo_List.models.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoTask, Long>{
}