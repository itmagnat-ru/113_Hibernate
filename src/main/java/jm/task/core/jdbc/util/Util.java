package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Util {
    private static final String HOSTNAME = "mysql49.hostland.ru";
    private static final String DBNAME = "host1335686_kata";
    private static final String LOGIN = "host1335686_kata";
    private static final String PASSWORD = "kata1377";

    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getConnection() {
        return sessionFactory;
    }
}
