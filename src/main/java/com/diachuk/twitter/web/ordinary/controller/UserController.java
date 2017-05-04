package com.diachuk.twitter.web.ordinary.controller;

import com.diachuk.twitter.domain.Timeline;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.UserRepository;
import com.diachuk.twitter.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeLineService timeLineService;

    @RequestMapping(value = "/all")
    public String showAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public String showUserPage(@PathVariable("id") User user,Model model){
        Timeline timeline = timeLineService.getUserTimeLine(user);

        model.addAttribute("pageOwner", user);
        model.addAttribute("timeline", timeline);

        return "user-page";
    }


//    @RequestMapping(value = "/register/valid")
//    public String registerValidUser(@Valid User user, Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            return "user-form";
//        }
//        userRepository.save(user);
//
//        Timeline timeline = timeLineService.getUserTimeLine(user);
//
//        model.addAttribute("currentUser", user);
//        model.addAttribute("pageOwner", user);
//        model.addAttribute("timeline", timeline);
//        return "redirect:/user-page";
//
//    }

    @RequestMapping(value = {"/edit/{id}", "/register"}, method = RequestMethod.GET)
    public String showUserForm(@PathVariable(value = "id",required = false) Long id){
        return "user-form";
    }

    //// TODO: 5/4/2017 ModelAndView ??

    @RequestMapping(value = {"/edit/{id}", "/register"}, method = RequestMethod.POST)
    public String postUserForm(@Valid User user, Errors errors){
        if (errors.hasErrors()) {
            System.out.println("LOL");
        }

        userRepository.save(user);

        return "redirect:/twitter/user/" + user.getId();
    }


//    BindingResult // TODO: 4/21/2017


    @ModelAttribute(name = "user")
    public User getSomeUser(@PathVariable(value = "id",required = false) User user) {
        return user;
    }




}
