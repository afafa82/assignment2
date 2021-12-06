/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): <  Johannes Edwin W >
 * Student Number: < 101233105>
 * Date: 2021-12-05
 * Description: <finding description>
 *********************************************************************************/

package com.the.bplus.recipeproject.controller;

import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import com.the.bplus.recipeproject.repository.RecipeRepository;
import com.the.bplus.recipeproject.repository.ShopcartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


//
//Project: COMP 3095 Recipe Assignment
//        * Assignment: 1 Web Development
//        * Author(s): Shehzad Contractor Student Number: 101285996
//        Amanda Caglioni    Student Number: 101237363
//        Rohan Khullar      Student Number: 101284533
//        Vishwa Mavani      Student Number: 101285743
//        * Date: 7th November 2021
//        * Description: This is a Search controller class which has one base urls /search/{query} and
//                       which get the user to search.js class which let the user to generate a containing
//                       query which can be further checked in RecipeRepository interface where the jpa query
//                       is mentioned which is findByDescriptionContaining which return the recipe details by searching
//                       it through the description. The search bar is available in the top of the recipe page
//                       and shows the blue color pop down links which takes you towards the specific details of
//                       a searched recipe

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    RecipeRepository recipeRepository;
    ShopcartRepository shopcartRepository;

    @GetMapping("/search/{query}")
    public ResponseEntity<?> searchRecipe(@PathVariable("query") String query) {
        List<Recipe> recipeList = this.recipeRepository.findByDescriptionContaining(query);
        return ResponseEntity.ok(recipeList);
    }

    /*@GetMapping("/search/{query}")
    public ResponseEntity<?> searchShopcart(@PathVariable("query") String query) {

        List<Shopcart> shopList = this.shopcartRepository.findByUseridContaining(query);
        return ResponseEntity.ok(shopList);
    }
    */



}