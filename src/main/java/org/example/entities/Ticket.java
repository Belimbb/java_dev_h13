package org.example.entities;

import jakarta.persistence.*;

import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity (name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Timestamp created_at;

    @Column
    private long client_id;

    @Column
    private long from_planet_id;

    @Column
    private long to_planet_id;
}
