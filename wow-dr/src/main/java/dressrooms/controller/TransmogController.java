package dressrooms.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dressrooms.model.Classe;
import dressrooms.model.Transmog;
import dressrooms.model.User;
import dressrooms.model.Item;
import dressrooms.repository.ClasseRepository;
import dressrooms.repository.ItemsRepository;
import dressrooms.repository.TransmogRepository;
import dressrooms.repository.UserRepository;
import dressrooms.service.IItemService;
import dressrooms.service.ITransmogService;
import dressrooms.service.IUserService;
import jakarta.servlet.http.HttpSession;

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

    @Autowired
    public ItemsRepository itemsRepository;

    @GetMapping("transmog/showTransmog/{id}")
    public String mostrarTransmog(@PathVariable int id, Model model) {
        Transmog t = mostrarConjunto(id);
        model.addAttribute("t", t);
        return "transmog/showTransmog";
    }

    @GetMapping("/transmog/createTransmog")
    public String mostrarCreateTransmog(@ModelAttribute Transmog transmog, HttpSession session) {
        if (session.getAttribute("transmog") == null) {
            transmog.setFecha(new Date());
            session.setAttribute("transmog", transmog);
        }
        return "transmog/createTransmog";
    }

    @PostMapping("/transmog/createTransmog")
    public String saveTransmog(Authentication auth, HttpSession session,
            @RequestParam("clase") int claseId, @RequestParam("nombre") String nombre) {
        Transmog transmog = (Transmog) session.getAttribute("transmog");
        Optional<Classe> c = classeRepository.findById(claseId);
        transmog.setClase(c.get());

        User u = userRepository.findByAlias(auth.getName());
        transmog.setNombre(nombre);
        transmog.setId_usuario(u.getId());
        transmogRepository.save(transmog);
        session.removeAttribute("transmog");

        return "redirect:/";
    }

    @PostMapping("/transmog/listItem")
    public String listItem(Model model, String searchItem, String ranura) {
        List<Item> items = itemsRepository.findByNombreContainingIgnoreCaseAndRanura(searchItem, ranura);
        model.addAttribute("items", items);
        return "transmog/listItem";
    }

    @PostMapping("/transmog/addItem")
    public String addItem(Model model, @RequestParam Integer idItem, HttpSession session) {
        Transmog transmog = (Transmog) session.getAttribute("transmog");
        String ranura = itemService.obtenerRanuraPorId(idItem);

        if (ranura.equals("HEAD")) {
            transmog.setId_head(idItem);
        }

        if (ranura.equals("SHOULDER")) {
            transmog.setId_shoulder(idItem);
        }

        if (ranura.equals("CHEST")) {
            transmog.setId_chest(idItem);
        }

        if (ranura.equals("CLOAK")) {
            transmog.setId_back(idItem);
        }

        if (ranura.equals("TABARD")) {
            transmog.setId_tabard(idItem);
        }

        if (ranura.equals("BODY")) {
            transmog.setId_shirt(idItem);
        }

        if (ranura.equals("WRIST")) {
            transmog.setId_wrists(idItem);
        }

        if (ranura.equals("HAND")) {
            transmog.setId_hands(idItem);
        }

        if (ranura.equals("WAIST")) {
            transmog.setId_waist(idItem);
        }

        if (ranura.equals("LEGS")) {
            transmog.setId_legs(idItem);
        }

        if (ranura.equals("FEET")) {
            transmog.setId_feet(idItem);
        }

        if (ranura.equals("WEAPON")) {
            if (transmog.getId_mainhand() == null) {
                transmog.setId_mainhand(idItem);
            } else {
                transmog.setId_offhand(idItem);
            }
        }

        if (ranura.equals("SHIELD")) {
            transmog.setId_offhand(idItem);
        }

        return "redirect:/transmog/createTransmog";
    }

    @PostMapping("/transmog/limpiar")
    public String limpiar(Model model, HttpSession session) {
        Transmog t = (Transmog) session.getAttribute("transmog");
        t.setClase(null);
        t.setId_head(null);
        t.setId_shoulder(null);
        t.setId_back(null);
        t.setId_chest(null);
        t.setId_tabard(null);
        t.setId_shirt(null);
        t.setId_wrists(null);
        t.setId_hands(null);
        t.setId_waist(null);
        t.setId_legs(null);
        t.setId_feet(null);
        t.setId_mainhand(null);
        t.setId_offhand(null);

        session.setAttribute("transmog", t);
        return "redirect:/transmog/createTransmog";
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
