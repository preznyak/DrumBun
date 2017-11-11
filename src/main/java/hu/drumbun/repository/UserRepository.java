package hu.drumbun.repository;

import hu.drumbun.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByEmail(String email);

}
