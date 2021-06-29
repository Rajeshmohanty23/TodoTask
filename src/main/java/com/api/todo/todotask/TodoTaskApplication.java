package com.api.todo.todotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TodoTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoTaskApplication.class, args);
    }

}
