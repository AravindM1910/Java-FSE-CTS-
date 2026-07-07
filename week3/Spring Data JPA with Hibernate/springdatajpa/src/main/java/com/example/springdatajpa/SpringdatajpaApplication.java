package com.example.springdatajpa;

import com.example.springdatajpa.model.Country;
import com.example.springdatajpa.service.CountryJpaService;
import com.example.springdatajpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	@Autowired
	private CountryService hibernateService;

	@Autowired
	private CountryJpaService jpaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Country c1 = new Country();
		c1.setCode("JP");
		c1.setName("Japan");

		hibernateService.addCountry(c1);
		System.out.println("Hibernate: " + hibernateService.getAllCountries());

		Country c2 = new Country();
		c2.setCode("CA");
		c2.setName("Canada");

		jpaService.addCountry(c2);
		System.out.println("Spring Data JPA: " + jpaService.getAllCountries());
	}
}
