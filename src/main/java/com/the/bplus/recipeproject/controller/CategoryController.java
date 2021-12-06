/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Johannes Edwin W, Youngil Kim >
 * Student Number: < 101233105, 101221938>
 * Date: 2021-12-04
 * Description: <Johannes made recipe/list and recipe/create Controllers, and
 * 						Youngil made more details for searching recipes with paging >
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;


import com.the.bplus.recipeproject.data.transfer.object.Category;
import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.UserRepository;
import com.the.bplus.recipeproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/categories")
    public String getCategories(Model model, Principal principal) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);
        List<Category> categoryList = this.categoryService.getCategories();
        model.addAttribute("user", user);
        model.addAttribute("categories", categoryList);
        return "category";
    }

    @PostMapping("/addCategories")
    public String addCategories(Category category) {
        this.categoryService.addCategories(category);
        return "redirect:/categories";
    }

}


