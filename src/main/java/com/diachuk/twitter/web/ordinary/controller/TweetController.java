package com.diachuk.twitter.web.ordinary.controller;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;
import com.diachuk.twitter.repository.UserRepository;
import com.diachuk.twitter.repository.impl.InMemUserRepository;
import com.diachuk.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ivan_Diachuk on 4/12/2017.
 */
@Controller
public class TweetController implements IController {

    @Autowired
    org.springframework.context.ApplicationContext applicationContext;

    @Autowired
    TweetService tweetService;

    @Autowired
    TweetRepository tweetRepository;


    @RequestMapping("/tweet")
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        System.out.println(applicationContext);
        System.out.println(applicationContext.getDisplayName());
        System.out.println(applicationContext.getBeanDefinitionNames());
        Tweet tweet = (Tweet) applicationContext.getBean("tweet");


        printWriter.println(tweetService.findAll().toString());

        printWriter.println(tweet.toString());
        printWriter.close();

    }

    @RequestMapping(value = "/tweets", method = RequestMethod.GET)
    public String allTweets(Model model) {
        Iterable allTweets = tweetService.findAll();
        model.addAttribute("allTweets",allTweets);
        return "tweets-page";
    }



    @RequestMapping(value = "/tweet/single/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String single(@PathVariable("id") Tweet tweet) {
        return tweet.toString();
    }


}
