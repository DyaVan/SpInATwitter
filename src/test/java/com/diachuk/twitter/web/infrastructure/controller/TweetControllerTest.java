package com.diachuk.twitter.web.infrastructure.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Ivan_Diachuk on 4/19/2017.
 */

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "WEB-INF/WebContext.xml"
})
public class TweetControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }

    @Test
    public void single() throws Exception {
        mockMvc.perform(get("/twitter/tweet/single?id=1"));
    }

}