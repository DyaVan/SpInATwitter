package com.diachuk.twitter.domain;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Timeline {

    private final ArrayList<Tweet> tweets = new ArrayList();

    public void put(Tweet tweet){
        tweets.add(tweet);
    }

    public Iterable<Tweet> getTweets() {
        Collections.sort(tweets);
        return new ArrayList(tweets);
    }

}

