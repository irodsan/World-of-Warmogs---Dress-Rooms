package dressrooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @GetMapping("/listadoUsuario")
    public String mostrarResultadosUsuario(Model model, Authentication auth, HttpSession session) {
        System.out.println("ENTRA EN METODO");
        String alias = auth.getName();
        User user = new User();
        if (session.getAttribute("Usuario") == null) {
            user = userService.buscarPorAlias(alias);
            user.setPassword(null);
            System.out.println("Usuario: " + user);
            session.setAttribute("usuario", user);
        }
        List<Transmog> res = transmogService.buscarTransmogsPorIdUsuario(user.getId());
        model.addAttribute("res", res);
        return "listado";
    }

    public String eliminarGuiones(String n) {
        return n.replace("_", " ");
    }

    @GetMapping("/bcrypt/{texto}")
    @ResponseBody
    public String encriptar(@PathVariable("texto") String texto) {
        return texto + "ENCRIPTADO: " + passwordEncoder.encode(texto);
    }

    @GetMapping("/userPanel")
    public String mostrarUserPanel(Model model) {
        return "/userPanel";
    }

}
