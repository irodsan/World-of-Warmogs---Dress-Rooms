package dressrooms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dressrooms.model.Transmog;
import dressrooms.repository.TransmogRepository;

@Controller
public class TransmogController {

    @Autowired
    private TransmogRepository repoTransmogs;

    @GetMapping("/transmog/{id}")
    public String mostrarTransmog(@PathVariable("id") int id, Model model) {
        Transmog t = mostrarConjunto(id);
        System.out.println("MOSTRANDO TRANSMOG");
        System.out.println(t);
        model.addAttribute("t", t);
        return "transmog";
    }

    private Transmog mostrarConjunto(int id) {
        Transmog t = null;
        Optional<Transmog> transmog = repoTransmogs.findById(id);
        if (transmog.isPresent()) {
            t = transmog.get();
        }
        return t;
    }

}
