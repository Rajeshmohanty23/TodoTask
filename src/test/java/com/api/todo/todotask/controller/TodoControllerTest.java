package com.api.todo.todotask.controller;

import com.api.todo.todotask.TestUtils.TestUtils;
import com.api.todo.todotask.models.Tasks;
import com.api.todo.todotask.models.Todos;
import com.api.todo.todotask.resources.TodoController;
import com.api.todo.todotask.services.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
@RestController
public class TodoControllerTest {

    @MockBean
    TodoService todoService;

    @InjectMocks
    TodoController todoController;

    private MockMvc mockMvc;

    @Before
    public void Setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(todoController)
                .build();
    }

    @Test
    public void addItemIfNotNullTest() throws Exception {
        Tasks tasks = new Tasks();
        tasks.setId(1L);
        tasks.setName("task1");
        tasks.setDescription("taskdetails1");
        List<Tasks> tasksList = new ArrayList<>();
        tasksList.add(tasks);
        Todos todos = new Todos(376, "Do a thing", "Something", tasksList);

        //Given
        when(todoService.addTodos(any(Todos.class))).thenReturn(todos);
        MvcResult result = mockMvc.perform(post("/todos")
        .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectToJson(todos)))
                .andReturn();
        //verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);

        // verify that service method was called once
        verify(todoService).addTodos(any(Todos.class));

        Todos resultTodos = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Todos.class);
        assertNotNull(resultTodos);
        assertEquals(1L, resultTodos.getId());
    }
}
