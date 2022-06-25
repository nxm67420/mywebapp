package com.mycompany.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/users/save")//URL Link
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users"; //Redirects to HTML File Name /users
    }

    /*@PostMapping("/users/delete")
    public String deleteUser(User user){
        service.delete(user);
        return "redirect/users";
    }*/
}
