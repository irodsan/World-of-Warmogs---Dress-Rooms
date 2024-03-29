package dressrooms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dressrooms.model.Transmog;

public interface TransmogRepository extends JpaRepository<Transmog, Integer> {

    List<Transmog> findByNombre(String nombre);

    List<Transmog> findByNombreContainingIgnoreCase(String nombre);

}
