package com.akinnova.bankserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaServer
@EnableWebMvc
public class BankServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceRegistryApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry
						.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("POST", "GET", "PUT", "PATCH", "OPTIONS");
			}
		};
	}
}
