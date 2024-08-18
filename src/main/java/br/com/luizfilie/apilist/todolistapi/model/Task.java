package br.com.luizfilie.apilist.todolistapi.model;

import br.com.luizfilie.apilist.todolistapi.repository.TaskRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double value;

    public Task(TaskRequestDTO data){
        this.name = data.name();
        this.value = data.value();
    }
}
