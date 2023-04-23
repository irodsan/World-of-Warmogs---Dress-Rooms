package dressrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
