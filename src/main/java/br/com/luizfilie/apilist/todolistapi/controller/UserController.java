package br.com.luizfilie.apilist.todolistapi.controller;

import br.com.luizfilie.apilist.todolistapi.model.User;
import br.com.luizfilie.apilist.todolistapi.model.UserRequestDTO;
import br.com.luizfilie.apilist.todolistapi.model.UserResponseDTO;
import br.com.luizfilie.apilist.todolistapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDTO data){
        userService.saveUser(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserRequestDTO data){
        User user = userService.authenticateUser(data);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
