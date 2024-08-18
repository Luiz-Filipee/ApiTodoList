package br.com.luizfilie.apilist.todolistapi.repository;

import br.com.luizfilie.apilist.todolistapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findTaskByNameEquals(String name);

    void deleteTaskById(Long id);
}
