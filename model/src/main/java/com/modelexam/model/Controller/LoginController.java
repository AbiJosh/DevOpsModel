package com.modelexam.model.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modelexam.model.Service.UserService;

@Controller
public class LoginController {
    @Autowired
    UserService service;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String check(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        com.modelexam.model.Domain.User user = service.validate(username,password);
        if(user!=null){
            model.addAttribute("name",username);
            return "home";
        }
        else{
            model.addAttribute("error","Invalid username or password");
            return "login";
        }
    }
}
