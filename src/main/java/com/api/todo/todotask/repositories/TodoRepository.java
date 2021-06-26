package com.api.todo.todotask.repositories;

import com.api.todo.todotask.models.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long>{
}

