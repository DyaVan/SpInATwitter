package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public interface TweetService {

    Tweet createTweet(String text, User user);

    void save(Tweet tweet);

    Iterable findAll();
}
