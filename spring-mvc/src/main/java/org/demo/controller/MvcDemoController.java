package org.demo.controller;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcDemoController {

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello() {
        return "hello";
    }
}
