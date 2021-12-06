/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Youngil Kim >
 * Student Number: < 101221938 >
 * Date: 2021-12-05
 * Description: < View Controller to see all >
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;

import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;



@Controller
public class View {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/", "/index"})
    public String view(Model model, Principal principal) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);
        model.addAttribute("user", user);
        return "redirect:/categories";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(User user){
        userRepository.save(user);

        return "redirect:/categories";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("message", new MessageDto("you have been logged out !", "alert-danger"));
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/profile")
    public String profile(Model model , Principal principal) {

        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);
        model.addAttribute("user", user);
        return "profile";
    }

}