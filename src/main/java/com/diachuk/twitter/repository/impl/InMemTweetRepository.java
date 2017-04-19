package com.diachuk.twitter.repository.impl;

import com.diachuk.twitter.annotation.Benchmark;
import com.diachuk.twitter.annotation.PostConstructBean;
import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class InMemTweetRepository implements TweetRepository {


    private Map<Long, Tweet> tweets = new HashMap<>();

    @PostConstruct
    public void initialize(){
        Tweet tweet1 = new Tweet(new User(1L,"Ivan"), "I traveled with (@id1) and (@id2) to the USA!!!");
        Tweet tweet2 = new Tweet(new User(2L, "Denis"), "I didn't travel with (@id3) and (@id1sdw)  and (@id14sdw)!)");
        tweets.put(tweet1.getId(), tweet1);
        tweets.put(tweet2.getId(), tweet2);
    }

    public void save(Tweet tweet) {
        tweets.put(tweet.getId(),tweet);
    }

    @Benchmark
    public Iterable findAll() {
        return tweets.values();
    }

    @Override
    public Tweet findById(Long id) {
        return tweets.get(id);
    }


}
