package com.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FbanEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbanEurekaClientApplication.class, args);
	}

}
