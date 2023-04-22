package dressrooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dressrooms.model.Item;
import dressrooms.repository.ItemsRepository;

@SpringBootApplication
public class WowDrApplication implements CommandLineRunner {

	@Autowired
	private ItemsRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(WowDrApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(repo);
		guardar();

	}

	public void guardar() {
		Item item = new Item();
		item.setId(4015);
		item.setNombre("Objeto 4015");
		item.setRanura("Hombros");
		item.setTipo("placas");
		repo.save(item);

	}

}
