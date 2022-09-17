package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model){
        List<User> user = (List<User>) userService.getAllUsers();
        model.addAttribute("users", user);

        return "users";
    }


    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.oneUser(id));
        return "edit";
    }
/*
    @PostMapping(value = "/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.save(id, user);
        return "redirect:/users";
    }

 */

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete((long) id);
        return "redirect:/users";
    }
}