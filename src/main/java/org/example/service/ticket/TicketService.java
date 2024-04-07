package org.example.service.ticket;

import org.example.HibernateUtil;
import org.example.entities.Client;
import org.example.entities.Ticket;
import org.example.service.client.ClientService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TicketService implements TicketCrudService{
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Override
    public void create(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            ticket.setId(null);
            session.save(ticket);
            tx.commit();
        }
        LOGGER.info("Ticket: "+ticket+", was created");
    }

    @Override
    public Ticket getById(long ticketId) {
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, ticketId);

            LOGGER.info("Ticket with id: "+ticketId+", was found. Ticket: "+ticket);
            return ticket;
        }
    }

    public Ticket getByIdWithCascades(long ticketId) {
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, ticketId);
            ticket.getFromPlanet();
            ticket.getToPlanet();
            ticket.getClient();
            LOGGER.info("Ticket with id: "+ticketId+", was found. Ticket: "+ticket);
            return ticket;
        }
    }

    @Override
    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ticket";
            Query<Ticket> query = session.createQuery(hql, Ticket.class);
            List<Ticket> results = query.getResultList();

            LOGGER.info("All Tickets received");
            return results;
        }
    }

    public List<Ticket> getAllWithCascades() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ticket";
            Query<Ticket> query = session.createQuery(hql, Ticket.class);
            List<Ticket> results = query.getResultList();

            for (Ticket ticket:results){
                ticket.getClient();
                ticket.getFromPlanet();
                ticket.getToPlanet();
            }

            LOGGER.info("All Tickets received");
            return results;
        }
    }

    @Override
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(ticket);
            tx.commit();

            LOGGER.info("Ticket: "+ticket+", was updated");
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(ticket);
            tx.commit();
        }
        LOGGER.info("Ticket: "+ticket+", was deleted");
    }
}
