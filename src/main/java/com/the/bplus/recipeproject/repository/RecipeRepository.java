package com.the.bplus.recipeproject.repository;

import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe , Integer> {

    List<Recipe> findByDescriptionContaining(String description);
}
