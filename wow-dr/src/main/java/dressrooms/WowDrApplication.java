package dressrooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import dressrooms.model.Profile;
import dressrooms.model.User;
import dressrooms.repository.ProfileRepository;
import dressrooms.repository.UserRepository;

@SpringBootApplication
public class WowDrApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(WowDrApplication.class, args);
	}

	public void run(String... args) throws Exception {
		initAdminUser();
		initProfiles();
	}

	private void initAdminUser() {
		if (!userRepository.findById(1).isPresent()) {
			System.out.println("Inicializando usuario Admin...");
			User adminUser = new User(0);
			adminUser.setAlias("Admin");
			adminUser.setEmail("admin@wowdr.com");
			adminUser.setPassword(passwordEncoder.encode("1234"));
			userRepository.save(adminUser);
		}
	}

	private void initProfiles() {
		Profile adminProfile = new Profile();
		adminProfile.setId(0);
		adminProfile.setPerfil("Admin");
		profileRepository.save(adminProfile);

		Profile userProfile = new Profile();
		userProfile.setId(1);
		userProfile.setPerfil("Usuario");
		profileRepository.save(userProfile);
	}

}
