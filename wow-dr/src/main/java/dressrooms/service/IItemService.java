package dressrooms.service;

import java.util.List;
import dressrooms.model.Item;

public interface IItemService {

    public String obtenerNombrePorId(Integer id);

    public String obtenerCalidadPorId(Integer id);

    public String obtenerRanuraPorId(Integer id);

    public String obtenerIconoPorId(Integer id);

    public List<Item> buscarPorNombre(String nombre);

}
