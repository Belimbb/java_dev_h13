package org.example.service.client;

import org.example.entities.Client;

import java.util.List;

public interface ClientCrudService {
    void create (Client client);
    Client getById (long clientId);
    List<Client> getAll ();
    void update (Client client);
    void delete (Client client);
}
