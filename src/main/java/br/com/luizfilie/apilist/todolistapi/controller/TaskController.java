package br.com.luizfilie.apilist.todolistapi.controller;

import br.com.luizfilie.apilist.todolistapi.model.Task;
import br.com.luizfilie.apilist.todolistapi.model.TaskRequestDTO;
import br.com.luizfilie.apilist.todolistapi.model.TaskResponseDTO;
import br.com.luizfilie.apilist.todolistapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskRequestDTO data) {
        taskService.saveTask(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean isRemoved = taskService.removeTask(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/{idSearchTask}")
//    public Task findByIdTask(@PathVariable Long idSearchTask){
//        return taskService.findByIdTask(idSearchTask);
//    }

    @GetMapping("/{nameSearchTask}")
    public Task findByIdName(@PathVariable String nameSearchTask){
        return taskService.findByIdName(nameSearchTask);
    }

}
