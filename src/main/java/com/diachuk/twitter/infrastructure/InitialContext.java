package com.diachuk.twitter.infrastructure;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class InitialContext {

    private Config config;

    public InitialContext(Config config) {
        this.config = config;
    }

    public Object lookup(String name) throws IllegalAccessException, InstantiationException {
        Class clazz = config.getImpl(name);
        return clazz.newInstance();
    }
}
