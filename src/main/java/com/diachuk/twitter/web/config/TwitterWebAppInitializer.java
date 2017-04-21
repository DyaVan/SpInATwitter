package com.diachuk.twitter.web.config;

import com.diachuk.twitter.config.TwitterContextConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Ivan_Diachuk on 4/20/2017.
 */
public class TwitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/twitter/*"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ TwitterContextConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebContextConfig.class };
    }

}
