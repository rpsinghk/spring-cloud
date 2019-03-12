package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaServer
@EnableHystrix
public class DiscoveryApplication {

	public static void main(String[] args) {
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		}catch(Exception e) {}
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
