package com.diachuk.twitter.domain;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Timeline {

    public Timeline(User owner, List<Tweet> tweets) {
        this.owner = owner;
        this.tweets = tweets;
    }

    private User owner;
    private List<Tweet> tweets;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}

