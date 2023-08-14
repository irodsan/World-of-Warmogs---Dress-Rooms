package dressrooms.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import dressrooms.model.Item;
import dressrooms.model.Transmog;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.TransmogRepository;

@Controller
public class TransmogController {

    @Autowired
    private ItemsRepository repoItems;
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

}
