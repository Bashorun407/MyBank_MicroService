package com.akinnova.banknotificationserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankNotificationServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankNotificationServiceRegistryApplication.class, args);
	}

}
