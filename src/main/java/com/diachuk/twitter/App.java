package com.diachuk.twitter;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.infrastructure.Context;
import com.diachuk.twitter.infrastructure.impl.ApplicationContext;
import com.diachuk.twitter.infrastructure.impl.JavaConfig;
import com.diachuk.twitter.repository.TweetRepository;
import com.diachuk.twitter.service.TweetService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        //TweetRepository tweetRepository = new InMemTweetRepository();

        /*InitialContext context = new InitialContext(new JavaConfig());
        TweetRepository tweetRepository = (TweetRepository) context.lookup("tweetRepo");*/

//        Context context = new ApplicationContext(new JavaConfig());
//        TweetRepository tweetRepository = context.getBean("tweetRepo");
//
//
//        TweetService tweetService = context.getBean("tweetService");
//
//
//
//        tweetRepository.findAll().forEach(System.out::println);
//        tweetRepository.save(new Tweet(new User(), "asf"));


        ConfigurableApplicationContext context = new FileSystemXmlApplicationContext(
                "AppConfig.xml","ServiceConfig.xml");


        TweetRepository tweetRepository = (TweetRepository) context.getBean("tweetRepository");
        TweetService tweetService = (TweetService) context.getBean("tweetService");

        tweetRepository.findAll().forEach(System.out::println);
        tweetRepository.save(new Tweet(new User(), "asf"));

        System.out.println(context.getBeanFactory().getBeanDefinition("tweetService"));



    }
}
