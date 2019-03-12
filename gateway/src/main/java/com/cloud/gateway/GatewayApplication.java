package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class GatewayApplication {

	public static void main(String[] args) {
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		}catch(Exception e) {}

		SpringApplication.run(GatewayApplication.class, args);
	}

}
