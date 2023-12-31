package com.ogawalucas.springexamples;

import org.testcontainers.containers.PostgreSQLContainer;

public class DatabaseContainer extends PostgreSQLContainer<DatabaseContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";
    private static DatabaseContainer container;

    private DatabaseContainer() {
        super(IMAGE_VERSION);
    }

    public static DatabaseContainer getInstance() {
        if (container == null) {
            container = new DatabaseContainer();
        }

        return container;
    }

    @Override
    public void start() {
        super.start();

        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }
}
