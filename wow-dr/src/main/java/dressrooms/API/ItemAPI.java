/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dressrooms.API;

/**
 *
 * @author ivanr
 */
public class ItemAPI {

    private int id;
    private String nombre;
    private String ranura;
    private String tipo;
    private String quality;

    public ItemAPI(int id, String nombre, String ranura, String tipo, String quality) {
        this.id = id;
        this.ranura = ranura;
        this.nombre = nombre;
        this.tipo = tipo;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRanura() {
        return ranura;
    }

    public void setRanura(String ranura) {
        this.ranura = ranura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "ItemAPI{" + "id=" + id + ", nombre=" + nombre + ", ranura=" + ranura + ", tipo=" + tipo + ", quality="
                + quality + '}';
    }

}
