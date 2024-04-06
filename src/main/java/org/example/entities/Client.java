package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
@Entity (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 3, max = 200, message = "Name must be bigger than 3 and lower than 200 letters")
    private String name;
}
