package br.com.luizfilie.apilist.todolistapi.services;

import br.com.luizfilie.apilist.todolistapi.model.*;
import br.com.luizfilie.apilist.todolistapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> getUsers(){
        List<UserResponseDTO> usersList = repository.findAll().stream()
                .map(UserResponseDTO::new).toList();
        return usersList;
    }

    public void saveUser(@RequestBody UserRequestDTO data) {
        User user = new User(data);
        repository.save(user);
    }

    public User authenticateUser(@RequestBody UserRequestDTO data){
        Optional<User> userOptional = repository.findUserByNameAndPassword(data.name(), data.password());
        if(userOptional.isPresent()){
            return userOptional.orElse(null);
        }
        return null;
    }
}
