package com.diachuk.twitter.infrastructure;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public interface Config {

    Class<?> getImpl(String name);

}
