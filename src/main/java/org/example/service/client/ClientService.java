package org.example.service.client;

import org.example.entities.Client;
import org.example.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientService implements ClientCrudService{
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Override
    public void create(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            client.setId(null);
            session.save(client);
            tx.commit();
        }
        LOGGER.info("Client: "+client+", was created");
    }

    @Override
    public Client getById(long clientId) {
        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, clientId);

            LOGGER.info("Client with id: "+clientId+", was found. Client: "+client);
            return client;
        }
    }

    @Override
    public List<Client> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM client";
            Query<Client> query = session.createQuery(hql, Client.class);
            List<Client> results = query.getResultList();

            LOGGER.info("All Clients received");
            return results;
        }
    }

    public List<Client> getAllWithCascades() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM client";
            Query<Client> query = session.createQuery(hql, Client.class);
            List<Client> results = query.getResultList();

            for (Client client:results){
                client.getTickets().size();
            }

            LOGGER.info("All Clients received");
            return results;
        }
    }

    @Override
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(client);
            tx.commit();

            LOGGER.info("Client: "+client+", was updated");
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(client);
            tx.commit();
        }
        LOGGER.info("Client: "+client+", was deleted");
    }
}
