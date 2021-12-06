package com.the.bplus.recipeproject.repository;


import com.the.bplus.recipeproject.data.transfer.object.Recipe;
import com.the.bplus.recipeproject.data.transfer.object.Shopcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopcartRepository extends JpaRepository<Shopcart, Integer> {
    //Shopcart findByUserId(String userid);
}
