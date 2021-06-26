package com.api.todo.todotask.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private long id;

    @Column(name = "task_name")
    private String name;

    @Column(name= "task_desc")
    private String description;

    public Tasks(){};

}
