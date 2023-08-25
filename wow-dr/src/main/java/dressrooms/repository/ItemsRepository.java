package dressrooms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {

    List<Item> findByNombreContainingIgnoreCase(String nombre);

    List<Item> findByNombreContainingIgnoreCaseAndRanura(String nombre, String ranura);

}
