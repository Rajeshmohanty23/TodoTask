package com.api.todo.todotask.services;

import com.api.todo.todotask.models.Todos;
import com.api.todo.todotask.repositories.TaskRepository;
import com.api.todo.todotask.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Service
public class TodoServiceImpl implements TodoService {
    private Todos todos;

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TaskRepository taskRepository;

    public Todos addTodos(Todos todos) {
        return repository.save(todos);
    }

    public List<Todos> getTodos() {
        List<Todos> todos = repository.findAll();
        System.out.println("Getting data from DB : " + todos);
        return todos;
    }

    public Optional<Todos> getTodoById(Long Id) {
        return repository.findById(Id);
    }

    public void deleteTodos(Todos user) {
        repository.delete(user);
    }
}
