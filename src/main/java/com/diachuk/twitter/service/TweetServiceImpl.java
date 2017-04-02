package com.diachuk.twitter.service;

import com.diachuk.twitter.repository.TweetRepository;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class TweetServiceImpl {

    private TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

}
