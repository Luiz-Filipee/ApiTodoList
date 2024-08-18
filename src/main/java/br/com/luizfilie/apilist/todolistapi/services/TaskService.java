package br.com.luizfilie.apilist.todolistapi.services;

import br.com.luizfilie.apilist.todolistapi.model.Task;
import br.com.luizfilie.apilist.todolistapi.model.TaskRequestDTO;
import br.com.luizfilie.apilist.todolistapi.model.TaskResponseDTO;
import br.com.luizfilie.apilist.todolistapi.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<TaskResponseDTO> getTasks() {
        List<TaskResponseDTO> taskList = repository.findAll().stream()
                .map(TaskResponseDTO::new).toList();
        return taskList;
    }

    public void saveTask(@RequestBody TaskRequestDTO data) {
        Task taskData = new Task(data);
        repository.save(taskData);
    }

    @Transactional
    public boolean removeTask(@PathVariable Long idRemoveTask){
        Optional<Task> task = repository.findById(idRemoveTask);
        if(task.isPresent()){
            repository.deleteTaskById(idRemoveTask);
            return true;
        }
        return false;
    }

    public Task findByIdTask(@PathVariable Long idSeachTask){
        Optional<Task> taskOptional = repository.findById(idSeachTask);
        return taskOptional.orElse(null);
    }

    public Task findByIdName(@PathVariable String nameSeachTask){
        Optional<Task> taskOptional = repository.findTaskByNameEquals(nameSeachTask);
        return taskOptional.orElse(null);
    }

}
