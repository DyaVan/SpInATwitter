package com.diachuk.twitter.repository.impl;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;
import com.diachuk.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@DependsOn("userRepository")
public class InMemTweetRepository implements TweetRepository {

    @Autowired
    UserRepository userRepository;

    private Map<Long, Tweet> tweets = new HashMap<>();


    @PostConstruct
    public void initialize( ){
        Tweet tweet1 = new Tweet( userRepository.findById(1L), "I traveled with (@id1) and (@id2) to the USA!!!");
        Tweet tweet2 = new Tweet( userRepository.findById(2L), "I didn't travel with (@id3) and (@id1sdw)  and (@id14sdw)!)");
        tweets.put(tweet1.getId(), tweet1);
        tweets.put(tweet2.getId(), tweet2);
    }

    public void save(Tweet tweet) {
        tweets.put(tweet.getId(),tweet);
    }

    public List<Tweet> findAll() {
        return tweets.values().stream().collect(Collectors.toList());
    }

    @Override
    public Tweet findById(Long id) {
        return tweets.get(id);
    }


}

















