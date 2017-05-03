package com.diachuk.twitter.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    @RequestMapping(value = "rest/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello from REST!";
    }
}
