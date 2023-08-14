package dressrooms;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dressrooms.model.Classe;
import dressrooms.model.Item;
import dressrooms.model.Profile;
import dressrooms.model.Transmog;
import dressrooms.model.User;
import dressrooms.model.UserProfile;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.ProfileRepository;
import dressrooms.repository.TransmogRepository;
import dressrooms.repository.UserRepository;

@SpringBootApplication
public class WowDrApplication implements CommandLineRunner {

	@Autowired
	private ItemsRepository repoItems;
	@Autowired
	private TransmogRepository repoTransmogs;
	@Autowired
	private UserRepository repoUsers;
	@Autowired
	private ProfileRepository repoProfiles;

	public static void main(String[] args) {
		SpringApplication.run(WowDrApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// initAdminUser();
		initProfiles();
		guardarTransmog();
		// System.out.println(getNombreItem(208193));

	}

	private void initAdminUser() {
		User adminUser = new User(0);
		adminUser.setAlias("ADMIN");
		adminUser.setEmail("admin@wowdr.com");
		adminUser.setPassword("admin");
		repoUsers.save(adminUser);
	}

	private void initProfiles() {
		Profile adminProfile = new Profile();
		adminProfile.setId(0);
		adminProfile.setPerfil("Admin");
		repoProfiles.save(adminProfile);

		Profile userProfile = new Profile();
		userProfile.setId(1);
		userProfile.setPerfil("Usuario");
		repoProfiles.save(userProfile);
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
		t.setId(5003);
		t.setFecha(new Date());
		t.setId_usuario(0);
		t.setNombre("Transfi creada desde APP");
		Classe c = new Classe();
		c.setId(3);
		t.setClase(c);
		t.setId_mainhand(208193);
		repoTransmogs.save(t);
	}

	public String getNombreItem(Integer id) {
		String nombre = "";
		Optional<Item> item = repoItems.findById(id);
		if (item.isPresent()) {
			item.get().getNombre();
		}
		System.out.println(nombre);
		return nombre;

	}

}
