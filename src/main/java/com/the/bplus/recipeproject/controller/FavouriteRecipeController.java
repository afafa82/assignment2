/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Youngil Kim >
 * Student Number: <101221938>
 * Date: 2021-12-04
 * Description: < Youngil made favourite Recipes controllers by clicking buttons>
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;

import com.the.bplus.recipeproject.data.transfer.object.FavouriteRecipe;
import com.the.bplus.recipeproject.data.transfer.object.Ingredient;
import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.service.FavouriteRecipeService;
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
public class FavouriteRecipeController {

    @Autowired
    private FavouriteRecipeService favouriteRecipeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;


    @PostMapping("/addFavouriteRecipe")
    public String addShopcarts(FavouriteRecipe favouriteRecipe) {
        System.out.println("============================");
        this.favouriteRecipeService.addFavouriteRecipes(favouriteRecipe);
        return "redirect:/favouriteRecipe";
    }

    @GetMapping("/favouriteRecipe")
    public String getIngredients(Model model , Principal principal) {
        String currentUserName =principal.getName();
        User user =  userRepository.findByUsername(currentUserName);
        List<Recipe> recipeList = this.recipeService.getRecipies();
        List<Ingredient> ingredients = this.ingredientService.getIngredients();
        model.addAttribute("user" , user);
        model.addAttribute("recipes", recipeList);
        model.addAttribute("ingredients" , ingredients);
        return "favouriteRecipe";
    }

}
