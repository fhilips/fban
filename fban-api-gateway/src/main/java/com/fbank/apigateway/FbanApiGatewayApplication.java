package com.fbank.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FbanApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbanApiGatewayApplication.class, args);
	}

}
