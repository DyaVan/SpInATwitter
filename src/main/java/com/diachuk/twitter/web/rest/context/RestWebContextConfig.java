package com.diachuk.twitter.web.rest.context;

import com.diachuk.twitter.domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan("com.diachuk.twitter.web.rest")
public class RestWebContextConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ConfigurableApplicationContext context;

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }



    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter((Converter<String, Tweet>) context.getBean("tweetConverter"));
    }



}
