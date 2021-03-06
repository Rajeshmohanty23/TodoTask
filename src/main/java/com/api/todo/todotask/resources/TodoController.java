package com.api.todo.todotask.resources;

import com.api.todo.todotask.exceptions.TodosNotFoundException;
import com.api.todo.todotask.models.Todos;
import com.api.todo.todotask.repositories.TaskRepository;
import com.api.todo.todotask.repositories.TodoRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TaskRepository taskRepository;

    //Get All Tasks
    @GetMapping("/todos")
    public Iterable<Todos> getAllitems(){
        return todoRepository.findAll();
    }

    //create a new to-do-item
    @PostMapping("/todos")
    public Todos createTodoItem(@NotNull @RequestBody Todos todos){
            return todoRepository.save(todos);
    }

    //Get details of a single to-do item by Id
    @GetMapping("/todos/{id}")
    public Todos getTodoItemsById(@PathVariable(value = "id") Long todoId) throws TodosNotFoundException{
        return todoRepository.findById(todoId)
                .orElseThrow(()-> new TodosNotFoundException(todoId));
    }


    // Update a single to-do item by Id
    @PutMapping("/todos/{id}")
    public Todos updateTodoItem(@PathVariable(value = "id") Long todoId,
                           @RequestBody Todos todoDetails) throws TodosNotFoundException {

        Todos todos = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodosNotFoundException(todoId));

        todos.setName(todoDetails.getName());
        todos.setDescription(todoDetails.getDescription());
        todos.setTasks(todoDetails.getTasks());

        return todoRepository.save(todos);
    }

    //Delete a to-do item by Id
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable(value = "id") Long todoId) throws TodosNotFoundException{
        Todos todos = todoRepository.findById(todoId)
                .orElseThrow(()-> new TodosNotFoundException(todoId));

        todoRepository.delete(todos);
        return ResponseEntity.ok().build();
    }

}
