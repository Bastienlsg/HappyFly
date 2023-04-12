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
    public String showAdminPage() {
        return "admin/index";
    }

    @GetMapping("/utilisateurs")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/utilisateur/{handle}")
    public String getUser(@PathVariable String handle, Model model) {
        Optional<User> optionalUser = userService.getUser(handle);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "admin/show_user";
        } else {
            return "admin/index";
        }
    }

    @GetMapping("/utilisateur/ajout")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    @PostMapping("/utilisateur/ajout")
    public String addUser(@ModelAttribute("user") @Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_user";
        }
        userService.createUser(user);
        return "redirect:" + user.getHandle();
    }

    @DeleteMapping("/utilisateur/{handle}/suppression")
    public ResponseEntity<User> removeUser(@PathVariable String handle) {
        User removedUser = userService.removeUser(handle);
        if(removedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(removedUser);
    }
}