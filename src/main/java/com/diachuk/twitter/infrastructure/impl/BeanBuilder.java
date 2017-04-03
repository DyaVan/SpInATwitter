package com.diachuk.twitter.infrastructure.impl;

import com.diachuk.twitter.annotation.Benchmark;
import com.diachuk.twitter.annotation.InMemBenchmarkProxy;
import com.diachuk.twitter.annotation.PostConstructBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Ivan_Diachuk on 4/3/2017.
 */
public class BeanBuilder<T>{

    private Class<T> beanType;
    private T bean;
    private T proxy;

    public BeanBuilder(Class<T> beanType) {
        this.beanType = beanType;
    }

    public BeanBuilder createBean() throws IllegalAccessException, InstantiationException {
        Constructor<?> constructor = beanType.getConstructors()[0];

        if (constructor.getParameterCount() == 0) {

        }else {
//            createBeanWithParameters()
        }

        return this;
    }

    public  BeanBuilder callPostCreateMethod() throws InvocationTargetException, IllegalAccessException {
        for (Method method : beanType.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstructBean.class)) {
                method.invoke(bean);
            }
        }
        return this;
    }

    public BeanBuilder callInitMethod() throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = bean.getClass();
        Method method;
        try {
            method = clazz.getMethod("init");
        } catch (NoSuchMethodException ex) {
            return this;
        }
        method.invoke(bean);
        return this;
    }

    public BeanBuilder createBeanProxy() {
        Class clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Benchmark.class)){
                bean = (T) Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                        bean.getClass().getInterfaces(), new InMemBenchmarkProxy(bean));
                break;
            }
        }
        proxy = bean;
        return this;
    }

    public  T build() {
        return proxy;
    }

    public  T build(boolean returnProxy) {
        if (returnProxy == false) {
            return bean;
        }
        return proxy;
    }

}
