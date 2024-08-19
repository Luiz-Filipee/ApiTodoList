package br.com.luizfilie.apilist.todolistapi.repository;

import br.com.luizfilie.apilist.todolistapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNameAndPassword(String username, String password);
}
