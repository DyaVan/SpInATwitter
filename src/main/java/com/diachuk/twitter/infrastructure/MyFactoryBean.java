package com.diachuk.twitter.infrastructure;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Ivan_Diachuk on 4/5/2017.
 */
public class MyFactoryBean implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return new String("Hi");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
