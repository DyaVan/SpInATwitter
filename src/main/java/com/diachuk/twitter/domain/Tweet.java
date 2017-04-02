package com.diachuk.twitter.domain;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Tweet {

    private User user;
    private String text;

    public Tweet() {

    }

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
    }


    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                '}';
    }
}
