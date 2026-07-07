package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Country;
import com.example.springdatajpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryJpaService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryJpaService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public boolean exists(String code) {
        return countryRepository.existsById(code);
    }
}
