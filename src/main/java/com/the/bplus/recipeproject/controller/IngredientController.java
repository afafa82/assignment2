/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Jillian Trafoord , Youngil Kim >
 * Student Number: < 101239902, 101221938>
 * Date: 2021-11-08
 * Description: <Jillian made recipe/list and recipe/create Controllers, and
 * 						Youngil made more details for searching recipes with paging >
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;


import com.the.bplus.recipeproject.data.transfer.object.Ingredient;
import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import com.the.bplus.recipeproject.service.IngredientService;
import com.the.bplus.recipeproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;



@Controller
public class IngredientController {


    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/ingredients")
    public String getIngredients(Model model , Principal principal) {
        String currentUserName =principal.getName();
        User user =  userRepository.findByUsername(currentUserName);
        List<Ingredient> ingredientList = this.ingredientService.getIngredients();
        List<Recipe> recipes = this.recipeService.getRecipies();
        model.addAttribute("user" , user);
        model.addAttribute("ingredients", ingredientList);
        model.addAttribute("recipies" , recipes);
        return "ingredient";
    }

    @PostMapping("/addIngredients")
    public String addIngredients(Ingredient ingredient) {
        this.ingredientService.addIngredients(ingredient);
        return "redirect:/ingredients";
    }


    @PostMapping("/deleteIngredients")
    public String deleteIngredients(Ingredient ingredient){
        this.ingredientService.deleteIngredient(ingredient);
        return "redirect:/ingredients";
    }

//    @PostMapping("/editIngredients")
//    public String editIngredients(Ingredient ingredient){
//        this.ingredientService.editIngredient(ingredient);
//        return "redirect:/ingredients";
//    }
}

