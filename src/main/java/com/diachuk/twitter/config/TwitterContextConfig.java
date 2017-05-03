package com.diachuk.twitter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({
        "com.diachuk.twitter.repository",
        "com.diachuk.twitter.service",
        "com.diachuk.twitter.web.converters"
})
public class TwitterContextConfig  {


}
