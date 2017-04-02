package com.diachuk.twitter.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by VA-N_ on 03.04.2017.
 */

public class InMemBenchmarkProxy implements InvocationHandler {

    private Object original;

    public InMemBenchmarkProxy(Object o){
        this.original = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        Method md = original.getClass().getMethod(method.getName(), method.getParameterTypes());
        Benchmark benchmark = md.getAnnotation(Benchmark.class);


        if(benchmark != null && benchmark.value()){
            long startTime = System.nanoTime();
            result = method.invoke(original, args);
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }else{
            result = method.invoke(original, args);
        }
        return result;
    }
}