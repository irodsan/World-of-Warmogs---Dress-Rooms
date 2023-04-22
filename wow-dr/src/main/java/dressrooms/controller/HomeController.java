package dressrooms.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dressrooms.model.Transmog;

@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Transmog> lista = getConjunto();
        model.addAttribute("conjuntos", lista);
        return "tabla";
    }

    private List<Transmog> getConjunto() {
        List<Transmog> lista = new LinkedList<Transmog>();

        try {
            Transmog c1 = new Transmog();
            c1.setId(1);
            c1.setNombre("pieza1");
            c1.setRanura("ranura1");

            Transmog c2 = new Transmog();
            c2.setId(2);
            c2.setNombre("pieza2");
            c2.setRanura("ranura2");

            Transmog c3 = new Transmog();
            c3.setId(3);
            c3.setNombre("pieza3");
            c3.setRanura("ranura3");

            Transmog c4 = new Transmog();
            c4.setId(4);
            c4.setNombre("pieza4");
            c4.setRanura("ranura4");

            lista.add(c1);
            lista.add(c2);
            lista.add(c3);
            lista.add(c4);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

}
