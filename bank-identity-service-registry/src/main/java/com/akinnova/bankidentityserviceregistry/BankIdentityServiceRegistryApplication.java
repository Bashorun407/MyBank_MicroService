package com.akinnova.bankidentityserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankIdentityServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankIdentityServiceRegistryApplication.class, args);
	}

}
