package com.api.todo.todotask.services;

import com.api.todo.todotask.models.Todos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class CreateTodo {
    private Todos todos;
}
