package dressrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
