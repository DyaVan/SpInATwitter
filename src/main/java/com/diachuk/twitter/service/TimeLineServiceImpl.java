package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Timeline;
import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeLineServiceImpl implements TimeLineService {

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Timeline getUserTimeLine(User user) {
        List<Tweet> allTweets = tweetRepository.findAll();
        List<Tweet> userTweets = allTweets
                .stream()
                .filter(tweet -> tweet.getUser().getId() == user.getId() )
                .collect(Collectors.toList());

        Timeline timeline = new Timeline(user, userTweets);
        return timeline;
    }

    @Override
    public Timeline getUserFullTimeLine(User user) {
        return null;
    }
}
