package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;

import org.example.entities.Ticket;
import org.example.service.client.ClientService;
import org.example.service.FlyWayService;
import org.example.service.planet.PlanetService;
import org.example.service.ticket.TicketService;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        FlyWayService flyway = FlyWayService.getInstance();
        flyway.migrate("src/main/resources/hibernate.properties");

        ClientService clientService = new ClientService();
        PlanetService planetService = new PlanetService();
        TicketService ticketService = new TicketService();

        Client client = new Client();
        Planet planetFrom = new Planet();
        Planet planetTo = new Planet();
        Ticket ticket = new Ticket();

        client.setName("TestClient");
        clientService.create(client);

        planetFrom.setName("FromPlanet");
        planetFrom.setId("FPL");
        planetTo.setName("ToPlanet");
        planetTo.setId("TPL");

        planetService.create(planetFrom);
        planetService.create(planetTo);

        ticket.setClient(client);
        ticket.setCreated_at(new Timestamp(System.currentTimeMillis()));
        ticket.setFromPlanet(planetFrom);
        ticket.setToPlanet(planetTo);

        ticketService.create(ticket);
    }
}