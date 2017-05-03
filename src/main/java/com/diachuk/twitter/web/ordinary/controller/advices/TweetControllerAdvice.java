package com.diachuk.twitter.web.ordinary.controller.advices;

import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.UserRepository;
import com.diachuk.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditorSupport;

@ControllerAdvice
public class TweetControllerAdvice {

    @Autowired
    TweetService tweetService;

    @Autowired
    private UserRepository userRepository;


//    @ModelAttribute
//    public User user(@RequestParam(value = "user", defaultValue = "1") User user) {
//        return user;
//    }

    @InitBinder
    public void tweetBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Long id = Long.valueOf(text);
                User user = userRepository.findById(id);
                setValue(user != null ? user : new User());

            }
        });
    }

}
