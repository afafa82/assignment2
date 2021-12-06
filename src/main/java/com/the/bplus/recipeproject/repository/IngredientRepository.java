package com.the.bplus.recipeproject.repository;

import com.the.bplus.recipeproject.data.transfer.object.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

   // void edit(Ingredient ingredient);
}
