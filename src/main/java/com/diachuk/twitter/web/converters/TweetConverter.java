package com.diachuk.twitter.web.converters;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("tweetConverter")
public class TweetConverter implements Converter<String,Tweet> {

    public TweetConverter(){
        System.out.println("Im created!");
    }

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet convert(String s) {
        Long id = Long.valueOf(s);
        Tweet tweet = tweetRepository.findById(id);
        return tweet;
    }
}
