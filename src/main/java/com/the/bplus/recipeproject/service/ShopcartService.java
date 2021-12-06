package com.the.bplus.recipeproject.service;

import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import com.the.bplus.recipeproject.data.transfer.object.Shopcart;
import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.ShopcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ShopcartService {
    @Autowired
    private ShopcartRepository shopcartRepository;

    @Autowired
    private HttpSession session;

    public Shopcart helperAddShopcart(Shopcart shopcart) {
        return shopcartRepository.saveAndFlush(shopcart);
    }

//    public List<Shopcart> getShopcart(User user) {
//        //return shopcartRepository.findByUserId(user.getUsername());
//        System.out.println(user);
//        return shopcartRepository.findAll();
//    }
    public void addShopcarts(Shopcart shopcart) {

        try {
            helperAddShopcart(shopcart);
            session.setAttribute("message", new MessageDto("Shopcart details have been added !", "alert-success"));

        } catch (Exception e) {

            session.setAttribute("message", new MessageDto("Error adding shopcart details!", "alert-danger"));
        }
    }


    public List<Shopcart> getShopcarts() {

        return shopcartRepository.findAll();

    }

}
