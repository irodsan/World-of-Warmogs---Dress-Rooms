package dressrooms.model;

public class Transmog {

    private Integer id;
    private String nombre;
    private String tipoArmadura;
    private String clase;
    private Integer id_usuario;

    public Transmog() {
    }

    public Transmog(Integer id, String nombre, String tipoArmadura, String clase, Integer id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoArmadura = tipoArmadura;
        this.clase = clase;
        this.id_usuario = id_usuario;
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

    public String getTipoArmadura() {
        return this.tipoArmadura;
    }

    public void setTipoArmadura(String tipoArmadura) {
        this.tipoArmadura = tipoArmadura;
    }

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", tipoArmadura='" + getTipoArmadura() + "'" +
                ", clase='" + getClase() + "'" +
                ", id_usuario='" + getId_usuario() + "'" +
                "}";
    }

}
