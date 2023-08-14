package dressrooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items_transmogs")
public class ItemTransmog {

    @Id
    private Integer id_item;
    @Id
    private Integer id_transmog;

    public ItemTransmog() {
    }

    public ItemTransmog(Integer id_item, Integer id_transmog) {
        this.id_item = id_item;
        this.id_transmog = id_transmog;
    }

    public Integer getId_item() {
        return this.id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public Integer getId_transmog() {
        return this.id_transmog;
    }

    public void setId_transmog(Integer id_transmog) {
        this.id_transmog = id_transmog;
    }

    @Override
    public String toString() {
        return """
                {\
                 id_item='\
                """ + getId_item() + "'" +
                ", id_transmog='" + getId_transmog() + "'" +
                "}";
    }

}
