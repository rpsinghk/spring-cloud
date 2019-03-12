package com.cloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

	public static void main(String[] args) {
		try {
			Thread.currentThread();
			Thread.sleep(10000);
		}catch(Exception e) {}

		SpringApplication.run(TurbineApplication.class, args);
	}

}
