package com.the.bplus.recipeproject.service;

import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUsers(User user)
    {
        userRepository.saveAndFlush(user);
    }



}
