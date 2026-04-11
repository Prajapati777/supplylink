package com.edutech.progressive.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionManager 
{
    
    private static final Properties properties = new Properties();

        static {
                try (InputStream inputStream = DatabaseConnectionManager.class
                                .getClassLoader()
                                                .getResourceAsStream("application.properties")) {

                                                            if (inputStream == null) {
                                                                            throw new RuntimeException("application.properties file not found");
                                                                                        }

                                                                                                    properties.load(inputStream);

                                                                                                                String driver = properties.getProperty("spring.datasource.driver-class-name");
                                                                                                                            if (driver == null || driver.trim().isEmpty()) {
                                                                                                                                            throw new RuntimeException("spring.datasource.driver-class-name not found in application.properties");
                                                                                                                                                        }

                                                                                                                                                                    Class.forName(driver);

                                                                                                                                                                            } catch (IOException e) {
                                                                                                                                                                                        throw new RuntimeException("Failed to load application.properties", e);
                                                                                                                                                                                                } catch (ClassNotFoundException e) {
                                                                                                                                                                                                            throw new RuntimeException("Database driver class not found", e);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                            private DatabaseConnectionManager() {
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                    public static Connection getConnection() {
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                        String url = properties.getProperty("spring.datasource.url");
                                                                                                                                                                                                                                                                    String username = properties.getProperty("spring.datasource.username");
                                                                                                                                                                                                                                                                                String password = properties.getProperty("spring.datasource.password");

                                                                                                                                                                                                                                                                                            if (url == null || url.trim().isEmpty()) {
                                                                                                                                                                                                                                                                                                            throw new RuntimeException("spring.datasource.url not found in application.properties");
                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                    return DriverManager.getConnection(url, username, password);

                                                                                                                                                                                                                                                                                                                                            } catch (Exception e) {
                                                                                                                                                                                                                                                                                                                                                        throw new RuntimeException("Failed to create database connection", e);
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    