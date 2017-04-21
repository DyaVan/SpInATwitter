package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.TweetRepository;
import com.diachuk.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public TweetServiceImpl(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(String text, User user) {
        return new Tweet(user, text);
    }

    @Override
    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Override
    public Iterable findAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Iterable<Tweet> findByUser(User user) {
        return null;
    }

    @Override
    public Tweet replaceReferencesWithUserNames(Tweet tweet) {
        Pattern pattern = Pattern.compile("\\(@id(\\d)+\\)");
        Matcher matcher = pattern.matcher(tweet.getText());
        StringBuffer output = new StringBuffer();

        List<User> mentions = new ArrayList<>();

        while (matcher.find()) {
            String reference = matcher.group();
            User mentionedUser = getUserByReference(reference);

            if (mentionedUser != null) {
                mentions.add(mentionedUser);
                matcher.appendReplacement(output, mentionedUser.getName() );
            }else {
                matcher.appendReplacement(output, reference );
            }
        }
        matcher.appendTail(output);

        tweet.setText(output.toString());
        tweet.setMentions(mentions);
        return tweet;
    }

    private User getUserByReference(String reference) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(reference);
        while (matcher.find()) {
            return userRepository.findById(Long.valueOf(matcher.group()));
        }
        return null;
    }


}
