package com.api.todo.todotask.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tasks")
@Entity
public class Tasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private long id;

    @Column(name = "task_name")
    private String name;

    @Column(name= "task_desc")
    private String description;
}
