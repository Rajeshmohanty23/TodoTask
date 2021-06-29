package com.api.todo.todotask.services;

import com.api.todo.todotask.models.Todos;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todos addTodos(Todos Todos);
    List<Todos> getTodos();
    Optional<Todos> getTodoById(Long Id);
    void deleteTodos(Todos user);
}
