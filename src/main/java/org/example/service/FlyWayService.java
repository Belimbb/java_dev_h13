package org.example.service;

import org.example.PropertiesReader;
import org.flywaydb.core.Flyway;

import java.util.HashMap;
import java.util.Map;

public class FlyWayService {
    private static final FlyWayService INSTANCE;

    static {
        INSTANCE = new FlyWayService();
    }

    private FlyWayService(){
    }
    public static FlyWayService getInstance() {
        return INSTANCE;
    }
    public void migrate(String propertiesFilePath){
        Map<String, String> properties = getProperties(propertiesFilePath);

        Flyway flyway = Flyway.configure().dataSource(properties.get("url"), properties.get("user"), properties.get("password")).load();
        flyway.migrate();
    }
    private Map<String, String> getProperties(String propertiesFilePath){
        PropertiesReader propertiesReader = new PropertiesReader(propertiesFilePath);
        Map<String, String> properties = new HashMap<>();

        properties.put("url", propertiesReader.getPostgresUrlConnection());
        properties.put("user", propertiesReader.getPostgresUsername());
        properties.put("password", propertiesReader.getPostgresPassword());

        return properties;
    }
}
