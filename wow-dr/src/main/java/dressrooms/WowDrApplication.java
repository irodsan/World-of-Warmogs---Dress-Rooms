package dressrooms;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dressrooms.model.Classe;
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
		guardarTransmog();
		// buscarTodos();

	}

	public void guardarItem() {
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

	public void guardarTransmog() {
		Transmog t = new Transmog();
		t.setId(5002);
		t.setFecha(new Date());
		t.setId_usuario(4015);
		t.setNombre("Transfi creada desde APP");
		Classe c = new Classe();
		c.setId(3);
		t.setClase(c);
		repoTransmogs.save(t);

	}

}
