package com.diachuk.twitter.web.config;


import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.web.infrastructure.converters.TweetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashSet;

@Configuration
@EnableWebMvc
@ComponentScan("com.diachuk.twitter.web")
public class WebContextConfig extends WebMvcConfigurerAdapter{

    @Autowired
    ConfigurableApplicationContext context;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


//    @Bean(name = "conversionService")
//    public ConversionService conversionService(){
//        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
//
//        factoryBean.setConverters(new HashSet(){{
//            add(new TweetConverter());
//        }} );
//        factoryBean.afterPropertiesSet();
//
//        ConversionService object = factoryBean.getObject();
//
//        return object;
//    }

    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter((Converter<String, Tweet>) context.getBean("tweetConverter"));
    }



}
