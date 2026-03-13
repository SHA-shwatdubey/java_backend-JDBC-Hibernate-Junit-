package com.capgemini.cachepractice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public Map<String, Object> handleError() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "The requested resource was not found");
        response.put("hint", "Try visiting http://localhost:8084/ or http://localhost:8084/api/products");
        return response;
    }
}


