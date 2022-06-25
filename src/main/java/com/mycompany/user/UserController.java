package com.mycompany.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users") //URL Link
    public String showUserList(Model model){
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", (List<User>)listUsers);
        return "users"; //HTML File Name
    }

    @GetMapping("/users/new") // URL Link
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        return "user_form"; //HTML File Name
    }

}
