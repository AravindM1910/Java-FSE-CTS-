package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Country;
import com.example.springdatajpa.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final HibernateUtil hibernateUtil;

    public CountryService(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public List<Country> getAllCountries() {
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Country", Country.class).list();
        }
    }

    public void addCountry(Country country) {
        Transaction tx = null;
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(country);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
