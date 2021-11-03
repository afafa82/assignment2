package com.the.hackers.recipeproject.service;

import com.the.hackers.recipeproject.data.transfer.object.MessageDto;
import com.the.hackers.recipeproject.data.transfer.object.Recipe;
import com.the.hackers.recipeproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
   private RecipeRepository recipeRepository;

    @Autowired
    private HttpSession session;

    public Recipe helperAddRecipies(Recipe recipe) {
        return recipeRepository.saveAndFlush(recipe);
    }

    public List<Recipe> getRecipies() {
        return recipeRepository.findAll();
    }

    public void addRecipies(Recipe recipe) {
        try {
            helperAddRecipies(recipe);
            session.setAttribute("message", new MessageDto("Recipe details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding recipe details!", "alert-danger"));
        }
    }


}
