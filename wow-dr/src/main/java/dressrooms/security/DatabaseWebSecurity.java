package dressrooms.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    @Bean
    UserDetailsManager usersCustom(DataSource datasource) {

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
        users.setUsersByUsernameQuery("Select alias, password, 1 from users where alias=?");
        users.setAuthoritiesByUsernameQuery(
                "Select u.alias, p.perfil from users_profiles up " +
                        "inner join users u on u.id = up.id_user " +
                        "inner join profile p on p.id = up.id_profile " +
                        "where u.alias = ?");
        return users;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()

                // Los recursos estáticos no requieren autenticacion
                .requestMatchers("/images/**", "/styles/**").permitAll()

                // Las vistas públicas no requieren autenticacion
                .requestMatchers("/", "/listado", "/signup", "/bcrypt/{texto}", "/transmog/showTransmog/**").permitAll()

                // Asignar permisos a URLs por roles
                .requestMatchers("/deleteUser").hasAnyAuthority("Admin")

                // El resto de URLs requieren autenticacion
                .anyRequest().authenticated()

                // El formulario de login no requiere autenticacion
                .and().formLogin().permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}