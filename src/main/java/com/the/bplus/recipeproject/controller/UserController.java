/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 1 >
 * Author(s): < Youngil Kim >
 * Student Number: < 101221938 >
 * Date: 2021-12-03
 * Description: < User Controller >
 *********************************************************************************/
package com.the.bplus.recipeproject.controller;

import com.the.bplus.recipeproject.data.transfer.object.User;
import com.the.bplus.recipeproject.data.transfer.object.MessageDto;
import com.the.bplus.recipeproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public String getUsers()
    {
        return "user";
    }

    @RequestMapping(value = ("/do_register"), method = {RequestMethod.POST , RequestMethod.GET})
    public String registerUser(@RequestParam("profileImage") MultipartFile file , User user , Model model , HttpSession session)
    {
        try {
            if (file.isEmpty()) {
                user.setPhoto("defaultPic.jpeg");
            } else {
                user.setPhoto(file.getOriginalFilename());
                File saveFile = new ClassPathResource("static/img").getFile();
                Files.copy(file.getInputStream(), Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.addUsers(user);
            model.addAttribute("user" , new User());
            session.setAttribute("message",new MessageDto("user have been registered !" , "alert-warning"));

            return "register";

        }catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message",new MessageDto("Something went wrong !" , "alert-danger"));

            return "register";
        }

    }
}
