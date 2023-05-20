package com.project.happy_fly.controller;

import com.project.happy_fly.model.User;
import com.project.happy_fly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin/show_users";
    }

    @GetMapping("/utilisateur/{handle}")
    public String getUser(@PathVariable String handle, Model model) {
        Optional<User> optionalUser = userService.getUser(handle);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "admin/show_user";
        } else {
            return "admin/show_users";
        }
    }

    @GetMapping("/utilisateur/ajout")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    @PostMapping("/utilisateur/ajout")
    public String addUser(@ModelAttribute("user") @Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_user";
        }
        if (userService.getUser(user.getHandle()).isPresent()) {
            result.rejectValue("handle", "error.user", "Cet utilisateur existe déjà");
            return "admin/add_user";
        }
        userService.createUser(user);
        return "redirect:" + user.getHandle();
    }

    @RequestMapping("/utilisateur/{handle}/suppression")
    public String removeUser(@PathVariable String handle) {
        userService.removeUser(handle);
        return "redirect:/admin";
    }
}