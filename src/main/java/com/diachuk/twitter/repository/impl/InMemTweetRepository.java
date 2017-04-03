package com.diachuk.twitter.repository.impl;

import com.diachuk.twitter.annotation.Benchmark;
import com.diachuk.twitter.annotation.PostConstructBean;
import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class InMemTweetRepository implements TweetRepository {


    private List<Tweet> tweets = new ArrayList();

    @PostConstructBean
    public void initialize(){
        tweets.add(new Tweet(new User(), "first"));
        tweets.add(new Tweet(new User(), "second)"));
    }

    public void save(Tweet tweet) {
        tweets.add(tweet);
    }

    @Benchmark
    public Iterable findAll() {
        return new ArrayList(tweets);
    }


    public void init() {

    }
}
