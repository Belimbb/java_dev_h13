package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);
    private final Properties properties;

    public PropertiesReader(String propertiesFilePath) {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(propertiesFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Problems with getting property file");
        }
    }

    public String getPostgresUrlConnection(){
        return properties.getProperty("hibernate.connection.url") +
                "?currentSchema=public";
    }
    public String getPostgresUsername() {
        return properties.getProperty("hibernate.connection.username");
    }

    public String getPostgresPassword() {
        return properties.getProperty("hibernate.connection.password");
    }
}