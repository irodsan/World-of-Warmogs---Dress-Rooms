package dressrooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    private Integer id;
    private String nombre;
    private String ranura;
    private String tipo;
    private String quality;

    public Item() {
    }

    public Item(Integer id, String nombre, String ranura, String tipo, String quality) {
        this.id = id;
        this.nombre = nombre;
        this.ranura = ranura;
        this.tipo = tipo;
        this.quality = quality;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRanura() {
        return this.ranura;
    }

    public void setRanura(String ranura) {
        this.ranura = ranura;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", ranura='" + getRanura() + "'" +
                ", tipo='" + getTipo() + "'" +
                ", quality='" + getQuality() + "'" +
                "}";
    }

}
