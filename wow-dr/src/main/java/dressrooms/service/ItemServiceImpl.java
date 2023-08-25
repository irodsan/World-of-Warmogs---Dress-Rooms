package dressrooms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dressrooms.model.Item;
import dressrooms.model.ItemIcon;
import dressrooms.repository.ItemsIconsRepository;
import dressrooms.repository.ItemsRepository;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ItemsIconsRepository itemsIconsRepository;

    public String obtenerNombrePorId(Integer id) {
        String nombreItem = "";
        Optional<Item> item = itemsRepository.findById(id);
        if (item.isPresent()) {
            nombreItem = item.get().getNombre();
        }
        return nombreItem;
    }

    public String obtenerCalidadPorId(Integer id) {
        String nombreItem = "";
        Optional<Item> item = itemsRepository.findById(id);
        if (item.isPresent()) {
            nombreItem = item.get().getQuality();
        }
        return nombreItem;
    }

    public String obtenerRanuraPorId(Integer id) {
        String ranura = "";
        Optional<Item> item = itemsRepository.findById(id);
        if (item.isPresent()) {
            ranura = item.get().getRanura();
        }
        return ranura;
    }

    public String obtenerIconoPorId(Integer id) {
        String urlIcon = "";
        Optional<ItemIcon> itemIcon = itemsIconsRepository.findById(id);
        if (itemIcon.isPresent()) {
            urlIcon = itemIcon.get().getUrl();
        }
        return urlIcon;
    }

    @Override
    public List<Item> buscarPorNombre(String nombre) {
        return itemsRepository.findByNombreContainingIgnoreCase(nombre);
    }

}
