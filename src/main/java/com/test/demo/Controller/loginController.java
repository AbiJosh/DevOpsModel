package com.test.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.test.demo.Domain.User;
import com.test.demo.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class loginController {
    @Autowired
    UserService service;
    
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String check(@RequestBody String username,
                        @RequestParam String password,
                        Model model) {
        User user = service.validate(username,password);
        if(user!=null){
            model.addAttribute("name", username);
            return "/home";
        }
        else{
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
    
    
}
