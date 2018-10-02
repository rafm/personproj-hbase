package com.github.rafm.personproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context.xml", Application.class);
		System.out.println("HBASE");
		context.registerShutdownHook();
		SpringApplication.run(Application.class, args);
	}
}