package dressrooms.model;

public class Item {

    private Integer id;
    private String nombre;
    private String ranura;
    private String tipo;

    public Item() {
    }

    public Item(Integer id, String nombre, String ranura, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ranura = ranura;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", ranura='" + getRanura() + "'" +
                ", tipo='" + getTipo() + "'" +
                "}";
    }

}
