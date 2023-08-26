package dressrooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dressrooms.model.Profile;
import dressrooms.model.User;
import dressrooms.service.ITransmogService;
import dressrooms.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ITransmogService transmogService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String mostrarRegister(@ModelAttribute User user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(User user) {

        String passCrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passCrypt);

        Profile profile = new Profile();
        profile.setId(1);
        user.addProfile(profile);
        userService.guardar(user);

        return "redirect:/login";
    }

    @GetMapping("/signOut")
    public String mostrarSignOut(Model model) {
        return "signOut";
    }

    @GetMapping("/config")
    public String mostrarUserPanel(Model model) {
        return "config";
    }

    @GetMapping("/modifyUser")
    public String mostrarModifyUser(Model model) {
        return "modifyUser";
    }

    @GetMapping("/deleteUser")
    public String mostrarDeleteUser(Model model) {
        List<User> users = userService.buscarTodos();
        model.addAttribute("users", users);
        return "deleteUser";
    }

    @PostMapping("/deleteUser/delete")
    public String deleteUser(@RequestParam Integer idUser) {
        System.out.println("ID USUARIOA  ELIMIANR: " + idUser);
        transmogService.eliminarTransmogs(transmogService.buscarTransmogsPorIdUsuario(idUser));
        userService.eliminar(idUser);
        return "redirect:/deleteUser";
    }

}
