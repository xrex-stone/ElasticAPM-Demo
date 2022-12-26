package com.example.appdemo;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

	public static void main(String[] args) {

		ElasticApmAttacher.attach();
		SpringApplication.run(AppDemoApplication.class, args);
	}

}
