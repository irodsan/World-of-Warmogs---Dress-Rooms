package dressrooms.service;

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
    private ItemsRepository repoItems;
    @Autowired
    private ItemsIconsRepository repoItemsIcons;

    public String obtenerNombrePorId(Integer id) {
        String nombreItem = "";
        Optional<Item> item = repoItems.findById(id);
        if (item.isPresent()) {
            nombreItem = item.get().getNombre();
        }
        return nombreItem;
    }

    public String obtenerCalidadPorId(Integer id) {
        String nombreItem = "";
        Optional<Item> item = repoItems.findById(id);
        if (item.isPresent()) {
            nombreItem = item.get().getQuality();
        }
        return nombreItem;
    }

    public String obtenerIconoPorId(Integer id) {
        String urlIcon = "";
        Optional<ItemIcon> itemIcon = repoItemsIcons.findById(id);
        if (itemIcon.isPresent()) {
            urlIcon = itemIcon.get().getUrl();
        }
        return urlIcon;
    }

}
