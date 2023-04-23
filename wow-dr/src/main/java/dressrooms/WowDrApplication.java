package dressrooms;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import dressrooms.model.Item;
import dressrooms.model.Transmog;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.TransmogRepository;

@SpringBootApplication
public class WowDrApplication implements CommandLineRunner {

	@Autowired
	private ItemsRepository repo;
	@Autowired
	private TransmogRepository repoTransmogs;

	public static void main(String[] args) {
		SpringApplication.run(WowDrApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(repo);
		buscarTodos();

	}

	public void guardar() {
		Item item = new Item();
		item.setId(4015);
		item.setNombre("Objeto 4015");
		item.setRanura("Hombros");
		item.setTipo("placas");
		repo.save(item);
	}

	public void buscarTodos() {
		Iterable<Transmog> transmogs = repoTransmogs.findAll();
		// Iterable<Transmog> transmogs = repoTransmogs.findAll
		for (Transmog t : transmogs) {
			System.out.println(t);
		}
	}

}
