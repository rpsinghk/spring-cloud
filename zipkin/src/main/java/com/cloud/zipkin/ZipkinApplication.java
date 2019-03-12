package com.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin2.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication {

	public static void main(String[] args) {
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		}catch(Exception e) {}
		SpringApplication.run(ZipkinApplication.class, args);
	}

}
