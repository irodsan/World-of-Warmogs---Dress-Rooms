package dressrooms.service;

import java.util.List;
import dressrooms.model.Classe;
import dressrooms.model.Transmog;

public interface ITransmogService {

    public Transmog mostrarConjunto(int id);

    public List<Transmog> buscarPorNombre(String nombre);

    public Integer obtenerImagenPersonajePorClase(Classe c);

    public List<Transmog> buscarNuevos();

}
