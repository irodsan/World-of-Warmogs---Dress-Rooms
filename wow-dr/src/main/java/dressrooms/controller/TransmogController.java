package dressrooms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dressrooms.model.Item;
import dressrooms.model.ItemIcon;
import dressrooms.model.Transmog;
import dressrooms.repository.ItemsIconsRepository;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.TransmogRepository;

@Controller
public class TransmogController {

    @Autowired
    private ItemsRepository repoItems;
    @Autowired
    private ItemsIconsRepository repoItemsIcons;
    @Autowired
    private TransmogRepository repoTransmogs;

    @GetMapping("transmog/showTransmog/{id}")
    public String mostrarTransmog(@PathVariable int id, Model model) {
        Transmog t = mostrarConjunto(id);
        model.addAttribute("t", t);
        return "transmog/showTransmog";
    }

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

    private Transmog mostrarConjunto(int id) {
        Transmog t = null;
        Optional<Transmog> transmog = repoTransmogs.findById(id);
        if (transmog.isPresent()) {
            t = transmog.get();
        }
        return t;
    }

    @GetMapping("/createTransmog")
    public String mostrarCreateTransmog(Model model) {
        System.out.println("MOSTRANDO CREATE");
        return "transmog/createTransmog";
    }

    public String itemClass(Integer id) {
        String quality = obtenerCalidadPorId(id);
        return quality != null ? quality + " my-auto" : "my-auto";
    }

    public String itemName(Integer id) {
        return obtenerNombrePorId(id);
    }

    public String itemIcon(Integer id) {
        String icon = obtenerIconoPorId(id);
        return icon != null ? icon : "../../images/items/inventoryslot_offhand.jpg";
    }

}
