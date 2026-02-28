package com.capgemini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("pageTitle", "Product List");
        return "product/list";
    }

    @GetMapping("/new")
    public String addProductForm(Model model) {
        model.addAttribute("pageTitle", "Add New Product");
        return "product/form";
    }

    @PostMapping
    public String saveProduct() {
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Edit Product");
        model.addAttribute("productId", id);
        return "product/form";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id) {
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Product Details");
        model.addAttribute("productId", id);
        return "product/view";
    }
}

