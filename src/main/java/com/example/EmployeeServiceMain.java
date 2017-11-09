package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.consumer.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceMain {
	
	public static void main(String...args ) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(EmployeeServiceMain.class, args);
		Consumer processedDataSubscriber = (Consumer) ctx.getBean(Consumer.class);
		String processedDataTopicName = "processedData";
		processedDataSubscriber.startListening(processedDataTopicName);
	}
	
}
