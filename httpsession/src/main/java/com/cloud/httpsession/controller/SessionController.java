package com.cloud.httpsession.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SessionController {
    @RequestMapping("/")
    public String helloAdmin() {
    	log.info("Hello Admin log");
        return "hello admin";
    }
}
