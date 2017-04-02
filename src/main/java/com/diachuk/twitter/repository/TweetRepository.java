package com.diachuk.twitter.repository;

import com.diachuk.twitter.domain.Tweet;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public interface TweetRepository {

    void save(Tweet tweet);

    Iterable findAll();

}
