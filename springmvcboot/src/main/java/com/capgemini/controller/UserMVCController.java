package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.UserDTO;
import com.capgemini.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserMVCController {

    @Autowired(required = false)
    private IUserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<UserDTO> users = new ArrayList<>();
        if(userService != null) {
            users = userService.getAllUsers();
        }
        model.addAttribute("users", users);
        model.addAttribute("pageTitle", "User List");
        return "user/list";
    }

    @GetMapping("/new")
    public String addUserForm(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("pageTitle", "Add New User");
        return "user/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UserDTO userDTO) {
        if(userService != null) {
            userService.createUser(userDTO);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        UserDTO user = new UserDTO();
        if(userService != null) {
            user = userService.getUserById(id);
        }
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Edit User");
        return "user/form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
        if(userService != null) {
            userService.updateUser(id, userDTO);
        }
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if(userService != null) {
            userService.deleteUser(id);
        }
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        UserDTO user = new UserDTO();
        if(userService != null) {
            user = userService.getUserById(id);
        }
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "User Details");
        return "user/view";
    }
}


