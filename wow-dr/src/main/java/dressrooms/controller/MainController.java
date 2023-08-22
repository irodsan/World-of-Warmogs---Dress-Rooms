package dressrooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dressrooms.model.Transmog;
import dressrooms.model.User;
import dressrooms.service.ITransmogService;
import dressrooms.service.IUserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    public ITransmogService transmogService;

    @Autowired
    public IUserService userService;

    /*
     * @GetMapping("/")
     * public String redirectToAnotherPage() {
     * return "redirect:/index";
     * }
     */
    @GetMapping("/")
    public String mostrarHome(Model model) {
        mostrarTabla(model);
        return "home";
    }

    @GetMapping("/index")
    public String mostrarIndex(Authentication auth, HttpSession session) {
        String alias = auth.getName();
        System.out.println("Nombre del usuario: " + alias);

        for (GrantedAuthority rol : auth.getAuthorities()) {
            System.out.println("Rol: " + rol.getAuthority());
        }

        if (session.getAttribute("Usuario") == null) {
            User u = userService.buscarPorAlias(alias);
            u.setPassword(null);
            System.out.println("Usuario: " + u);
            session.setAttribute("usuario", u);

        }

        return "redirect:/";
    }

    // @ModelAttribute("/index")

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Transmog> nuevos = transmogService.buscarNuevos();
        model.addAttribute("nuevos", nuevos);
        return "tabla";
    }

    @GetMapping("/listado")
    public String mostrarResultados(Model model, @RequestParam String nombre) {
        List<Transmog> res = transmogService.buscarPorNombre(nombre);
        model.addAttribute("res", res);
        return "listado";
    }

    public List<Transmog> buscarPorNombre(String nombre) {
        List<Transmog> transmogs = transmogService.buscarPorNombre(nombre);
        return transmogs;
    }
    /*
     * @GetMapping("/index")
     * public String mostrarIndex(Authentication auth) {
     * String username = auth.getName();
     * System.out.println("Nombre del usuario " + username);
     * return "redirect:/";
     * }
     */

    public String eliminarGuiones(String n) {
        return n.replace("_", " ");
    }

}
