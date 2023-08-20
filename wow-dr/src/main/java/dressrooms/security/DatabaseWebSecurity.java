package dressrooms.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

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
}