package com.api.todo.todotask.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "todos")
@Entity
public class Todos implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "todo_item_id")
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @OneToMany(targetEntity = Tasks.class,cascade = CascadeType.ALL)
        @JoinColumn(name = "todo_task_fk", referencedColumnName = "todo_item_id")
        private List<Tasks> tasks;
}
