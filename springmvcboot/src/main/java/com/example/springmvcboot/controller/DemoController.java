package com.example.springmvcboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springmvcboot.model.Users;
import com.example.springmvcboot.repository.UserRepository;

@Controller
public class DemoController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String createUser() {
		return "login";
	}
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users users) {
		ur.save(users);
		return "sucess";
	}
	
	
	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // login process
    @PostMapping("/login")
    public String login(@ModelAttribute Users user) {

        Users dbUser =
                ur.findByEmailAndPassword(
                        user.getEmail(),
                        user.getPassword());

        if(dbUser != null) {
            return "sucess";
        }

        return "failure";
    }
	
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number = request.getParameter("contact");
//		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
		
//		return "sucess";
//		
//	}
	
//	@PostMapping("/create-account")
//	public String register(@ModelAttribute Users users) {
//		System.out.println(users.getName());
//		System.out.println(users.getEmail());
//		System.out.println(users.getContact());
//		
//		return "sucess";
//	}
	

	
}
