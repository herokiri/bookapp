package ru.dstu.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dstu.bookapp.dtos.RegistrationUserDto;
import ru.dstu.bookapp.services.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String createBookForm(Model model) {
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String createBook(@ModelAttribute RegistrationUserDto registrationUserDto) {
        userService.createNewUser(registrationUserDto);
        return "redirect:/main/unsecured";
    }

    @GetMapping("/secured")
    public String securedData(Model model) {
        model.addAttribute("data", "secured");
        return "main/secured";
    }

    @GetMapping("/unsecured")
    public String unsecuredData(Model model) {
        model.addAttribute("data", "unsecured");
        return "main/unsecured";
    }

    @GetMapping("/info")
    public String infoData(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("data", authentication);
        return "main/info";
    }


    @GetMapping("/admin")
    public String adminData(Model model) {
        model.addAttribute("data", "admindata");
        return "main/admin";
    }


}
