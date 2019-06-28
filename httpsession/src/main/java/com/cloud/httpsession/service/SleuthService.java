package com.cloud.httpsession.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SleuthService {
 
    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        log.info("Doing some work");
    }
}
