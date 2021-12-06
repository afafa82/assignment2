/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Youngil Kim >
 * Student Number: < 101221938 >
 * Date: 2021-12-05
 * Description: < This is about planning meals >
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;


import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.data.transfer.object.PlanMeal;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.service.PlanMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class PlanMealController {

    @Autowired
    private PlanMealService planMealService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/planMeals")
    public String getPlanMeals(Model model, Principal principal) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);
        List<PlanMeal> planMealList = this.planMealService.getPlanMeals();
        model.addAttribute("user", user);
        model.addAttribute("planMeals", planMealList);
        return "planMeal";
    }

    @PostMapping("/addPlanMeals")
    public String addPlanMeals(PlanMeal planMeal) {
        this.planMealService.addPlanMeals(planMeal);
        return "redirect:/planMeals";
    }

}



