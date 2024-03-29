package dressrooms.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transmogs")
public class Transmog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Date fecha;
    @OneToOne
    @JoinColumn(name = "id_clase")
    private Classe clase;
    private Integer id_usuario;
    private Integer id_head;
    private Integer id_shoulder;
    private Integer id_back;
    private Integer id_chest;
    private Integer id_shirt;
    private Integer id_tabard;
    private Integer id_wrists;
    private Integer id_hands;
    private Integer id_waist;
    private Integer id_legs;
    private Integer id_feet;
    private Integer id_mainhand;
    private Integer id_offhand;

    public Transmog() {
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

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Classe getClase() {
        return this.clase;
    }

    public void setClase(Classe clase) {
        this.clase = clase;
    }

    public Integer getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_head() {
        return this.id_head;
    }

    public void setId_head(Integer id_head) {
        this.id_head = id_head;
    }

    public Integer getId_shoulder() {
        return this.id_shoulder;
    }

    public void setId_shoulder(Integer id_shoulder) {
        this.id_shoulder = id_shoulder;
    }

    public Integer getId_back() {
        return this.id_back;
    }

    public void setId_back(Integer id_back) {
        this.id_back = id_back;
    }

    public Integer getId_chest() {
        return this.id_chest;
    }

    public void setId_chest(Integer id_chest) {
        this.id_chest = id_chest;
    }

    public Integer getId_shirt() {
        return this.id_shirt;
    }

    public void setId_shirt(Integer id_shirt) {
        this.id_shirt = id_shirt;
    }

    public Integer getId_tabard() {
        return this.id_tabard;
    }

    public void setId_tabard(Integer id_tabard) {
        this.id_tabard = id_tabard;
    }

    public Integer getId_wrists() {
        return this.id_wrists;
    }

    public void setId_wrists(Integer id_wrists) {
        this.id_wrists = id_wrists;
    }

    public Integer getId_hands() {
        return this.id_hands;
    }

    public void setId_hands(Integer id_hands) {
        this.id_hands = id_hands;
    }

    public Integer getId_waist() {
        return this.id_waist;
    }

    public void setId_waist(Integer id_waist) {
        this.id_waist = id_waist;
    }

    public Integer getId_legs() {
        return this.id_legs;
    }

    public void setId_legs(Integer id_legs) {
        this.id_legs = id_legs;
    }

    public Integer getId_feet() {
        return this.id_feet;
    }

    public void setId_feet(Integer id_feet) {
        this.id_feet = id_feet;
    }

    public Integer getId_mainhand() {
        return this.id_mainhand;
    }

    public void setId_mainhand(Integer id_mainhand) {
        this.id_mainhand = id_mainhand;
    }

    public Integer getId_offhand() {
        return this.id_offhand;
    }

    public void setId_offhand(Integer id_offhand) {
        this.id_offhand = id_offhand;
    }

    @Override
    public String toString() {
        return """
                {\
                 id='\
                """ + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", fecha='" + getFecha() + "'" +
                ", clase='" + getClase() + "'" +
                ", id_usuario='" + getId_usuario() + "'" +
                ", id_head='" + getId_head() + "'" +
                ", id_shoulder='" + getId_shoulder() + "'" +
                ", id_back='" + getId_back() + "'" +
                ", id_chest='" + getId_chest() + "'" +
                ", id_shirt='" + getId_shirt() + "'" +
                ", id_tabard='" + getId_tabard() + "'" +
                ", id_wrists='" + getId_wrists() + "'" +
                ", id_hands='" + getId_hands() + "'" +
                ", id_waist='" + getId_waist() + "'" +
                ", id_legs='" + getId_legs() + "'" +
                ", id_feet='" + getId_feet() + "'" +
                ", id_mainhand='" + getId_mainhand() + "'" +
                ", id_offhand='" + getId_offhand() + "'" +
                "}";
    }

}
