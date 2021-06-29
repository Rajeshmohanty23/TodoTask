package com.api.todo.todotask;

import com.api.todo.todotask.exceptions.TodosNotFoundException;
import com.api.todo.todotask.models.Tasks;
import com.api.todo.todotask.models.Todos;
import com.api.todo.todotask.repositories.TodoRepository;
import com.api.todo.todotask.resources.TodoController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@Ignore
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TodoTaskApplicationTests {

    @MockBean
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoController todoController;

    @Before
    public void Setup(){
        Tasks task = new Tasks(1L,"Task1","TaskDetail1");
        List<Tasks> tasks = new ArrayList<>();
        tasks.add(task);
        when(todoRepository.findAll()).thenReturn(Stream
                .of(new Todos(376, "Do a thing", "Something", tasks)).collect(Collectors.toList()));
    }

    @Test
    public void getAllitemsTest() throws TodosNotFoundException {
        Tasks task = new Tasks(1L,"Task1","TaskDetail1");
        List<Tasks> tasks = new ArrayList<>();
        tasks.add(task);

        when(todoRepository.findAll()).thenReturn(Stream
                .of(new Todos(376, "Do a thing", "Something", tasks)).collect(Collectors.toList()));
        Assertions.assertEquals(1, todoController.getAllitems().size());

    }
    @Test
    public void createTodoItemTest() {
        Tasks task = new Tasks(1L,"Task1","TaskDetail1");
        List<Tasks> tasks = new ArrayList<>();
        tasks.add(task);
        Todos todos = new Todos(376, "Do a thing", "Something", tasks);

        when(todoRepository.save(todos)).thenReturn(todos);
        Assertions.assertEquals(todos, todoController.createTodoItem(todos));
    }


    @Test
    public void getTodoItemsByIdTest() throws Exception {
        Long Id = 1L;
        List<Tasks> tasksList = new ArrayList<>();
        tasksList.add(new Tasks(1L,"Task1","TaskDetail1"));
        when(todoRepository.getById(Id))
                .thenReturn(new Todos(1L, "Do a thing", "Something", tasksList ));
        Assertions.assertEquals(1, todoController.getTodoItemsById(Id).getTasks().size());
    }

}
