package dressrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dressrooms.model.Classe;
import dressrooms.model.Transmog;
import dressrooms.service.IItemService;
import dressrooms.service.ITransmogService;
import dressrooms.service.IUserService;

@Controller
public class TransmogController {

    @Autowired
    public IItemService itemService;
    @Autowired
    public ITransmogService transmogService;
    @Autowired
    public IUserService userService;

    @GetMapping("transmog/showTransmog/{id}")
    public String mostrarTransmog(@PathVariable int id, Model model) {
        Transmog t = mostrarConjunto(id);
        model.addAttribute("t", t);
        return "transmog/showTransmog";
    }

    @GetMapping("/createTransmog")
    public String mostrarCreateTransmog(Model model) {
        return "transmog/createTransmog";
    }

    public String obtenerUsuarioPorId(Integer id) {
        return userService.obtenerUsuarioPorId(id);
    }

    public String obtenerNombrePorId(Integer id) {
        return itemService.obtenerNombrePorId(id);
    }

    public String obtenerCalidadPorId(Integer id) {
        return itemService.obtenerCalidadPorId(id);
    }

    public String obtenerIconoPorId(Integer id) {
        return itemService.obtenerIconoPorId(id);
    }

    public Transmog mostrarConjunto(Integer id) {
        return transmogService.mostrarConjunto(id);
    }

    public Integer obtenerImagenPersonajePorClase(Classe c) {
        return transmogService.obtenerImagenPersonajePorClase(c);
    }

}
