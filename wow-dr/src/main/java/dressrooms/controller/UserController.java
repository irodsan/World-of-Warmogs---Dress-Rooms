package dressrooms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String mostrarRegister(Model model) {
        return "register";
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
        return "deleteUser";
    }

}
