package com.api.todo.todotask.repositories;

import com.api.todo.todotask.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long> {
}