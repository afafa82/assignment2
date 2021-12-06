/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 1 >
 * Author(s): < Youngil Kim >
 * Student Number: < 101221938 >
 * Date: 2021-11-08
 * Description: < for adding and getting the Plan a meal details using JPA methods >
 *********************************************************************************/
package com.the.bplus.recipeproject.service;


import com.the.bplus.recipeproject.repository.PlanMealRepository;
import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import com.the.bplus.recipeproject.data.transfer.object.PlanMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;





@Service
public class PlanMealService {

    @Autowired
    private PlanMealRepository planMealRepository;

    @Autowired
    private HttpSession session;

    public PlanMeal helperAddPlanMeals(PlanMeal planMeal) {
        return planMealRepository.saveAndFlush(planMeal);
    }

    public List<PlanMeal> getPlanMeals() {
        return planMealRepository.findAll();
    }

    public void addPlanMeals(PlanMeal planMeal) {
        try {
            helperAddPlanMeals(planMeal);
            session.setAttribute("message", new MessageDto("PlanMeal details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding planMeal details!", "alert-danger"));
        }
    }


}

