package com.diachuk.twitter.web.infrastructure.controller;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ivan_Diachuk on 4/12/2017.
 */
@Controller
public class TweetController implements IController/*,Applic      ationContextAware*/ {

    @Autowired
    org.springframework.context.ApplicationContext applicationContext;

    @Autowired
    TweetService tweetService;

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

}
