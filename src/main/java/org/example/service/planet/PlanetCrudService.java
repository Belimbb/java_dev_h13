package org.example.service.planet;

import org.example.entities.Planet;

import java.util.List;

public interface PlanetCrudService {
    void create (Planet planet);
    Planet getById (String planetId);
    List<Planet> getAll ();
    void update (Planet client);
    void delete (Planet client);
}
