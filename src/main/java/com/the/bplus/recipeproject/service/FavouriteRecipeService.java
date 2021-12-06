/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 1 >
 * Author(s): < Youngil Kim >
 * Student Number: < 101221938 >
 * Date: 2021-12-04
 * Description: < Favourite Recipe Service with sessions as well >
 *********************************************************************************/
package com.the.bplus.recipeproject.service;

import com.the.bplus.recipeproject.data.transfer.object.FavouriteRecipe;
import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import com.the.bplus.recipeproject.repository.FavouriteRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class FavouriteRecipeService {
    @Autowired
    private FavouriteRecipeRepository favouriteRecipeRepository;

    @Autowired
    private HttpSession session;

    public FavouriteRecipe helperAddFavouriteRecipe(FavouriteRecipe favouriteRecipe) {
        return favouriteRecipeRepository.saveAndFlush(favouriteRecipe);
    }


    public void addFavouriteRecipes(FavouriteRecipe favouriteRecipe) {
        System.out.println("<<<<<"+favouriteRecipe+">>>>");
        try {
            helperAddFavouriteRecipe(favouriteRecipe);
            session.setAttribute("message", new MessageDto("Favourite Recipe details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding Favourite Recipe details!", "alert-danger"));
        }
    }
}
