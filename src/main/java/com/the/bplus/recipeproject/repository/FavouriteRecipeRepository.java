package com.the.bplus.recipeproject.repository;

import com.the.bplus.recipeproject.data.transfer.object.FavouriteRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRecipeRepository extends JpaRepository<FavouriteRecipe, Integer> {
}
