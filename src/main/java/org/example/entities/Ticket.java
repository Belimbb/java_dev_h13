package org.example.entities;


import jakarta.persistence.*;

import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanet;
}
