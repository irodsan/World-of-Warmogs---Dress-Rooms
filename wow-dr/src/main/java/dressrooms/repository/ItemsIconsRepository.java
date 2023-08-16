package dressrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.ItemIcon;

public interface ItemsIconsRepository extends JpaRepository<ItemIcon, Integer> {

}