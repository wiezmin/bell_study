package ru.bellintegrator.organizationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bellintegrator.organizationapi.model.Organization;

@SpringBootApplication
public class OrganizationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationApiApplication.class, args);
	}

}
