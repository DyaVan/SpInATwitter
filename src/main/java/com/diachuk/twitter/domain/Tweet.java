package com.diachuk.twitter.domain;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class Tweet implements Comparable{

    static long idCounter = 1L;

    private long id;
    private User user;
    private String text;
    private Date date;
    private int likes;
    private boolean retweeted;
    private int retweets;
    private List<User> mentions = new ArrayList<>();


    public Tweet() {

    }

    public Tweet(User user, String text) {
        this.id = idCounter++;
        this.user = user;
        this.text = text;
        this.date = new Date();
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public void setMentions(List<User> mentions) {
        this.mentions = mentions;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        return (this.date.before(((Tweet) o).date) ? 1 : -1);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", likes=" + likes +
                ", retweeted=" + retweeted +
                ", retweets=" + retweets +
                ", mentions=" + mentions +
                '}';
    }
}
