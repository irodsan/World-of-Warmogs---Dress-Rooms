package dressrooms.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dressrooms.model.Classe;
import dressrooms.model.Transmog;
import dressrooms.model.User;
import dressrooms.repository.ClasseRepository;
import dressrooms.repository.TransmogRepository;
import dressrooms.repository.UserRepository;
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

    @Autowired
    public ClasseRepository classeRepository;

    @Autowired
    public TransmogRepository transmogRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("transmog/showTransmog/{id}")
    public String mostrarTransmog(@PathVariable int id, Model model) {
        Transmog t = mostrarConjunto(id);
        model.addAttribute("t", t);
        return "transmog/showTransmog";
    }

    @GetMapping("/transmog/createTransmog")
    public String mostrarCreateTransmog(@ModelAttribute Transmog transmog) {
        return "transmog/createTransmog";
    }

    @PostMapping("/transmog/createTransmog")
    public String saveTransmog(Authentication auth, Transmog transmog) {
        Optional<Classe> c = classeRepository.findById(4);
        transmog.setClase(c.get());
        transmog.setFecha(new Date());
        System.out.println("Nombre: " + transmog.getNombre());
        System.out.println("Alias del usuario: " + auth.getName());
        User u = userRepository.findByAlias(auth.getName());

        transmog.setId_usuario(u.getId());
        transmogRepository.save(transmog);
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
