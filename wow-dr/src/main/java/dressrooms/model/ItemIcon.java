package dressrooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items_icons")
public class ItemIcon {

    @Id
    private Integer id;
    private String url;

    public ItemIcon() {
    }

    public ItemIcon(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId_item(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", url='" + getUrl() + "'" +
                "}";
    }

}
