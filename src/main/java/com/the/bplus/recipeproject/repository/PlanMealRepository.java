package com.the.bplus.recipeproject.repository;

import com.the.bplus.recipeproject.data.transfer.object.PlanMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMealRepository extends JpaRepository<PlanMeal , Long> {
}
