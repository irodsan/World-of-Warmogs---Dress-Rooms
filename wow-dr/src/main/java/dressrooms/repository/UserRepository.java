package dressrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
