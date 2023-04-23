package dressrooms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dressrooms.model.Item;
import dressrooms.model.Transmog;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.TransmogRepository;

@SpringBootApplication
public class WowDrApplication implements CommandLineRunner {

	@Autowired
	private ItemsRepository repoItems;
	@Autowired
	private TransmogRepository repoTransmogs;

	public static void main(String[] args) {
		SpringApplication.run(WowDrApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(repoItems);
		buscarTodos();

	}

	public void guardar() {
		Item item = new Item();
		item.setId(4015);
		item.setNombre("Objeto 4015");
		item.setRanura("Hombros");
		item.setTipo("placas");
		repoItems.save(item);
	}

	public void buscarTodos() {
		List<Transmog> transmogs = repoTransmogs.findAll();
		for (Transmog t : transmogs) {
			System.out.println(t);
		}
	}

}
