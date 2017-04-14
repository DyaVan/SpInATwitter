package com.diachuk.twitter.domain;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.util.Date;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Tweet implements Comparable{

    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    private Date date;
    private int likes;

    public Tweet() {

    }

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                '}';
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        return (this.date.before(((Tweet) o).date) ? 1 : -1);
    }
}
