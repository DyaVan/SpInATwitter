package com.diachuk.twitter.web.config;

import com.diachuk.twitter.config.TwitterContextConfig;
import com.diachuk.twitter.web.ordinary.context.WebContextConfig;
import com.diachuk.twitter.web.rest.context.RestWebContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register( TwitterContextConfig.class );
//        rootContext.scan(
//                "com.diachuk.twitter.repository",
//                "com.diachuk.twitter.service");
        servletContext.addListener(new ContextLoaderListener(rootContext));

//        AnnotationConfigWebApplicationContext webSharedContext = new AnnotationConfigWebApplicationContext();
//        webSharedContext.setParent(rootContext);
//        webSharedContext.register( WebSharedContextConfig.class );

        // ordinary dispatcher servlet
        AnnotationConfigWebApplicationContext ordinaryWebContext = new AnnotationConfigWebApplicationContext();
        ordinaryWebContext.setParent(rootContext);
        ordinaryWebContext.register( WebContextConfig.class );
        ordinaryWebContext.scan("com.diachuk.twitter.web.ordinary");
        ServletRegistration.Dynamic ordinaryDispatcher =
                servletContext.addServlet("ordinaryDispatcher", new DispatcherServlet(ordinaryWebContext));
        ordinaryDispatcher.setLoadOnStartup(1);
        ordinaryDispatcher.addMapping("/twitter/*");

        // rest dispatcher servlet
        AnnotationConfigWebApplicationContext restWebContext = new AnnotationConfigWebApplicationContext();
        restWebContext.setParent(rootContext);
        restWebContext.register( RestWebContextConfig.class );
//        restWebContext.scan("com.diachuk.twitter.web.rest");
        ServletRegistration.Dynamic restDispatcher=
                servletContext.addServlet("restDispatcher", new DispatcherServlet(restWebContext));
        restDispatcher.setLoadOnStartup(1);
        restDispatcher.addMapping("/twitterRest/*");
    }


}
