package com.the.bplus.recipeproject.service;


import com.the.bplus.recipeproject.data.transfer.object.Ingredient;
import com.the.bplus.recipeproject.repository.IngredientRepository;
import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class IngredientService {


    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private HttpSession session;

    public Ingredient helperAddIngredients(Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public void addIngredients(Ingredient ingredient) {
        try {
            helperAddIngredients(ingredient);
            session.setAttribute("message", new MessageDto("Ingredient details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding ingredient details!", "alert-danger"));
        }
    }

    public void deleteIngredient(Ingredient ingredient){
        ingredientRepository.delete(ingredient);
    }


//    public void editIngredient(Ingredient ingredient) {
////        ingredientRepository.edit(ingredient);
//    }
}
