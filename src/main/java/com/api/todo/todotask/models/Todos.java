package com.api.todo.todotask.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class Todos {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "todo_item_id")
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
        private List<Tasks> tasks;

        public Todos() {
        }

        @Override
        public String toString() {
            return "Todos [id=" + id + ", name=" + name + ", desc=" + description + ", published=" + tasks + "]";
        }


}
