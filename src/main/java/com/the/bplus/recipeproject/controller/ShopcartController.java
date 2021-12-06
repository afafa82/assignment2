/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Jillian Trafoord, Youngil Kim >
 * Student Number: < 101239902, 101221938>
 * Date: 2021-12-06
 * Description: <shopping controller for lists up>
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;

import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.ShopcartRepository;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.data.transfer.object.Shopcart;
//import com.the.hackers.recipeproject.repository.DocumentRepository;
import com.the.bplus.recipeproject.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;
import java.util.List;

@Controller
public class ShopcartController {

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopcartRepository shopcartRepository;



    @PostMapping("/addShopcart")
    public String addShopcarts(Shopcart shopcart) {
        System.out.println("============================");
        this.shopcartService.addShopcarts(shopcart);
        return "redirect:/shopcart";
    }

    @GetMapping("/shopList")
    public String getShopsList(Model model , Principal principal) {
        String currentUserName =principal.getName();

//        shopcartRepository.findByUserId(currentUserName);
        User user =  userRepository.findByUsername(currentUserName);
        List<Shopcart> shopcart = this.shopcartService.getShopcarts();
        //List<Shopcart> shopcart = (List<Shopcart>) shopcartRepository.findByUserId("afafa82");


        System.out.println(shopcart);
        model.addAttribute("user" , user);
        model.addAttribute("shopcart" , shopcart);
        return "shopList";

    }


}
