package dressrooms.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dressrooms.model.Item;
import dressrooms.model.Transmog;
import dressrooms.repository.TransmogRepository;

@Controller
public class MainController {

    @Autowired
    private TransmogRepository repoTransmogs;

    @GetMapping("/deleteUser")
    public String mostrarDeleteUser(Model model) {
        return "deleteUser";
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        Iterable<Transmog> nuevos = buscarNuevos();
        model.addAttribute("nuevos", nuevos);
        return "index";
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        return "login";
    }

    @GetMapping("/modifyUser")
    public String mostrarModifyUser(Model model) {
        return "modifyUser";
    }

    @GetMapping("/register")
    public String mostrarRegister(Model model) {
        return "register";
    }

    @GetMapping("/signOut")
    public String mostrarSignOut(Model model) {
        return "signOut";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Transmog> conjuntos = getConjunto();
        model.addAttribute("conjuntos", conjuntos);
        return "tabla";
    }

    @GetMapping("/transmog")
    public String mostrarTransmog(Model model) {
        List<Item> lista = getItems();
        model.addAttribute("items", lista);
        return "transmog";
    }

    @GetMapping("/userPanel")
    public String mostrarUserPanel(Model model) {
        return "userPanel";
    }

    private List<Item> getItems() {
        List<Item> lista = new LinkedList<Item>();
        try {
            Item item = new Item();
            item.setId(4015);
            item.setNombre("Objeto 4015");
            item.setRanura("Hombros");
            item.setTipo("Placas");

            Item item2 = new Item();
            item2.setId(1234);
            item2.setNombre("Objeto 1234");
            item2.setRanura("Cabeza");
            item2.setTipo("Tela");

            lista.add(item);
            lista.add(item2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    private List<Transmog> getConjunto() {
        List<Transmog> lista_T = new LinkedList<Transmog>();

        try {
            Transmog t = new Transmog();
            System.out.println("Transfiguracion creada");
            System.out.println(t);
            t.setId(5000);
            t.setId_usuario(4015);
            t.setNombre("TEST");
            t.setClase(1);
            t.setFecha("2023-04-23 16:56:14");

            Transmog t2 = new Transmog();
            System.out.println("Transfiguracion creada2");
            System.out.println(t);
            t2.setId(5001);
            t2.setId_usuario(4015);
            t2.setNombre("TEST2");
            t2.setClase(5);
            t2.setFecha("2023-04-23 18:56:14");
            lista_T.add(t2);
            repoTransmogs.save(t2);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista_T;
    }

    public Iterable<Transmog> buscarNuevos() {
        Iterable<Transmog> transmogs = repoTransmogs.findAll(Sort.by("fecha"));
        for (Transmog t : transmogs) {
            System.out.println(t);
        }
        return transmogs;
    }

}
