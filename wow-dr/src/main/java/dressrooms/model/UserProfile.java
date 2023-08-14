package dressrooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_profiles")
public class UserProfile {

    @Id
    private Integer id_user;
    @Id
    private Integer id_profile;

    public UserProfile() {
    }

    public Integer getId_user() {
        return this.id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_profile() {
        return this.id_profile;
    }

    public void setId_profile(Integer id_profile) {
        this.id_profile = id_profile;
    }

    @Override
    public String toString() {
        return """
                {\
                 id_user='\
                """ + getId_user() + "'" +
                ", id_profile='" + getId_profile() + "'" +
                "}";
    }

}
