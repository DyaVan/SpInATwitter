package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.repository.TweetRepository;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }


    @Override
    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Override
    public Iterable findAll() {
        return tweetRepository.findAll();
    }
}
