package ru.dstu.bookapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dstu.bookapp.dtos.auth.LoginUserDto;
import ru.dstu.bookapp.dtos.auth.RegistrationUserDto;
import ru.dstu.bookapp.exceptions.PasswordMismatchException;
import ru.dstu.bookapp.services.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String createBookForm(Model model) {
        model.addAttribute("registrationUserDto", new RegistrationUserDto());
        return "auth/registration";
    }


    @PostMapping("/registration")
    public String createBook(@ModelAttribute @Valid RegistrationUserDto registrationUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // В случае ошибок валидации, возвращаем пользователя на страницу регистрации
            return "auth/registration";
        }

        try {
            userService.createNewUser(registrationUserDto);
        } catch (PasswordMismatchException e) {
            bindingResult.rejectValue("confirmPassword",
                    "error.registrationUserDto",
                    e.getMessage());

            return "auth/registration";
        }
        catch (Exception e) {
            bindingResult.rejectValue("username",
                    "error.registrationUserDto",
                    "Пользователь с таким именем уже сущесвует");

            return "auth/registration";
        }

        return "redirect:/main/unsecured";
    }

}
