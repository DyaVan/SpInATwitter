package com.diachuk.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@ComponentScan({
        "com.diachuk.twitter.repository",
        "com.diachuk.twitter.service",
        "com.diachuk.twitter.web.converters"
})
public class TwitterContextConfig  {

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }


}
