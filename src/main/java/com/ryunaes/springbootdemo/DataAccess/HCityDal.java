package com.ryunaes.springbootdemo.DataAccess;

import com.ryunaes.springbootdemo.Entities.City;
import org.apache.catalina.SessionIdGenerator;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import java.util.List;

@Repository
public class HCityDal implements ICityDal{

    @Autowired
    public HCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    @Transactional
    public List<City> getAll() {
       Session session = entityManager.unwrap(Session.class);
       List<City> cities = session.createQuery("from world", City.class).getResultList();
       return cities;
    }

    @Override
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);

    }

    @Override
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);


    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(city);
    }

    @Override
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

}
