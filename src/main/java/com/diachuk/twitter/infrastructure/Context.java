package com.diachuk.twitter.infrastructure;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public interface Context {

    <T> T getBean(String name) throws Exception;

}
