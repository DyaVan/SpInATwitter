package com.diachuk.twitter.repository;

import com.diachuk.twitter.domain.Tweet;

import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public interface TweetRepository {

    void save(Tweet tweet);

    List<Tweet> findAll();

    Tweet findById(Long id);

}
