package com.diachuk.twitter.infrastructure.impl;

import com.diachuk.twitter.annotation.Benchmark;
import com.diachuk.twitter.annotation.InMemBenchmarkProxy;
import com.diachuk.twitter.annotation.PostConstructBean;
import com.diachuk.twitter.infrastructure.Config;
import com.diachuk.twitter.infrastructure.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class ApplicationContext implements Context{

    private final Config config;
    private final Map<String, Object> beans = new HashMap();

    public ApplicationContext(Config config) {
        this.config = config;
    }


    public <T> T getBean(String beanName) throws Exception {
        T bean = (T) beans.get(beanName);

        if (bean != null) {
            return bean;
        }

        Class<?> classTemplate = config.getImpl(beanName);
        if (classTemplate == null) {
            throw new RuntimeException("Bean not found");
        }
        bean = (T) classTemplate.newInstance();

        callPostConstructBean(bean);
        bean = createProxy(bean);
        callInitMethod(bean);

        beans.put(beanName, bean);
        return bean;


    }

    private <T> void callPostConstructBean(T bean) throws InvocationTargetException, IllegalAccessException {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstructBean.class)) {
                method.invoke(bean);
            }
        }
    }

    private <T> void callInitMethod(T bean) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = bean.getClass();
        Method method;
        try {
            method = clazz.getMethod("init");
        } catch (NoSuchMethodException ex) {
            return;
        }
        method.invoke(bean);
    }

    private <T> T createProxy(T bean) {
        Class clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Benchmark.class)){
                bean = (T) Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                        bean.getClass().getInterfaces(), new InMemBenchmarkProxy(bean));
                break;
            }
        }
        return bean;
    }


}
