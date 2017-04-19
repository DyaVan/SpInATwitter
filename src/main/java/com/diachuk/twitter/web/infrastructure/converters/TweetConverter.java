package com.diachuk.twitter.web.infrastructure.converters;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.repository.TweetRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Ivan_Diachuk on 4/19/2017.
 */
public class TweetConverter implements Converter<String,Tweet> {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet convert(String s) {
        Long id = Long.valueOf(s);
        Tweet tweet = tweetRepository.findById(id);
        return tweet;
    }
}
