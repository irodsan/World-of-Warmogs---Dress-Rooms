package dressrooms.repository;

import org.springframework.data.repository.CrudRepository;
import dressrooms.model.Item;

public interface ItemsRepository extends CrudRepository<Item, Integer> {

}
