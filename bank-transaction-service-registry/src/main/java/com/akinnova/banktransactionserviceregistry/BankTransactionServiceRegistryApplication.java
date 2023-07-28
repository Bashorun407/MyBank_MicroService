package com.akinnova.banktransactionserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankTransactionServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTransactionServiceRegistryApplication.class, args);
	}

}
