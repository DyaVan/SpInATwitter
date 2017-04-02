package com.diachuk.twitter.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Timeline {

    private final List<Tweet> tweets = new ArrayList();

    public void put(Tweet tweet){
        tweets.add(tweet);
    }

    public Iterable<Tweet> getTweets() {
        return new ArrayList(tweets);
    }
}

