package com.diachuk.twitter.web.infrastructure.controller;

import com.diachuk.twitter.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value ="/create", method= RequestMethod.POST)
    public  String createUser(@ModelAttribute("userrr")User user, Model model) {
        System.out.println(model.asMap().get("userrr"));
        return user.toString();
    }


    @RequestMapping( method= RequestMethod.GET)
    public String openPage() {
        return "create-user-page";
    }

    @ModelAttribute("userrr")
    public User superUser() {
        return new User(100L,"SUPERUSER_Dimas");
    }


}
