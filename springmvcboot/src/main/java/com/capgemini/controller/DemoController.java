package com.capgemini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Welcome to Springmvcboot");
        model.addAttribute("message", "This is a traditional Spring MVC application");
        return "common/index";
    }

    @GetMapping("home")
    public String homePage(Model model) {
        model.addAttribute("pageTitle", "Home Page");
        return "common/home";
    }

    @GetMapping("about")
    public String aboutPage(Model model) {
        model.addAttribute("pageTitle", "About Us");
        model.addAttribute("version", "0.0.1-SNAPSHOT");
        model.addAttribute("company", "Capgemini");
        return "common/about";
    }
}
