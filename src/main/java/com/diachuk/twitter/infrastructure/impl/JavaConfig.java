package com.diachuk.twitter.infrastructure.impl;

import com.diachuk.twitter.infrastructure.Config;
import com.diachuk.twitter.repository.impl.InMemTweetRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class JavaConfig implements Config {

    private final Map<String, Class<?>> classes = new HashMap();

    {
        classes.put("tweetRepo", InMemTweetRepository.class);
    }

    public Class<?> getImpl(String name) {
        return classes.get(name);
    }


}