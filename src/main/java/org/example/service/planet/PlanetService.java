package org.example.service.planet;

import org.example.entities.Planet;
import org.example.HibernateUtil;
import org.example.service.client.ClientCrudServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlanetCrudServiceImpl implements PlanetCrudService{
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCrudServiceImpl.class);

    @Override
    public void create(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(planet);
            tx.commit();

            LOGGER.info("Client: "+planet+", was created");
        }
    }

    @Override
    public Planet getById(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            Planet planet = session.get(Planet.class, planetId);

            LOGGER.info("Client with id: "+planetId+", was found. Client: "+planet);
            return planet;
        }
    }

    @Override
    public List<Planet> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM planet";
            Query<Planet> query = session.createQuery(hql, Planet.class);
            List<Planet> results = query.getResultList();

            LOGGER.info("All Planets received");
            return results;
        }
    }

    @Override
    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(planet);
            tx.commit();

            LOGGER.info("Planet: "+planet+", was updated");
        }
    }

    @Override
    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(planet);
            tx.commit();

            LOGGER.info("Planet: "+planet+", was deleted");
        }
    }
}
