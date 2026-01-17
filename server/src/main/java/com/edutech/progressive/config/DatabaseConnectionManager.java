package com.edutech.progressive.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnectionManager {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private DatabaseConnectionManager() {
    }

    private static void loadProperties() {
        try (InputStream in = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (in == null) {
                throw new IllegalStateException("application.properties not found on classpath");
            }
            PROPERTIES.load(in);
            String driver = PROPERTIES.getProperty("db.driver");
            if (driver != null && !driver.isBlank()) {
                Class.forName(driver);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = PROPERTIES.getProperty("db.url");
        String username = PROPERTIES.getProperty("db.username");
        String password = PROPERTIES.getProperty("db.password");
        return DriverManager.getConnection(url, username, password);
    }
}
