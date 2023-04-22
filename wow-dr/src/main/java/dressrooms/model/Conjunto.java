package dressrooms.model;

public class Conjunto {

    private Integer id;
    private String nombre;
    private String ranura;

    public Conjunto() {
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", ranura='" + getRanura() + "'" +
                "}";
    }

}
