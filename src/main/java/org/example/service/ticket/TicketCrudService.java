package org.example.service.ticket;

import org.example.entities.Ticket;

import java.util.List;

public interface TicketCrudService {
    void create (Ticket ticket);
    Ticket getById (long ticketId);
    List<Ticket> getAll();
    void update (Ticket ticket);
    void delete (Ticket ticket);
}
