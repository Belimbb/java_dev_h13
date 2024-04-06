package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity (name = "planet")
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase letters and numbers")
    private String id;

    @Column
    @Size (min = 1, max = 500, message = "Name must be bigger than 1 and lower than 500 letters")
    private String name;
}
