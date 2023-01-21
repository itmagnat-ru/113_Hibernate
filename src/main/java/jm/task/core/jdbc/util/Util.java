package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Util {
    private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "kata_users";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static SessionFactory getConnection() {

        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME;

        try {
            Configuration configuration = new Configuration()
//                    .setProperty("hibernate.connection.driver_class", DRIVER)
                    .setProperty("hibernate.connection.url", connectionURL)
                    .setProperty("hibernate.connection.username", LOGIN)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass(User.class);
//                    .setProperty("hibernate.c3p0.min_size","5")
//                    .setProperty("hibernate.c3p0.max_size","200")
//                    .setProperty("hibernate.c3p0.max_statements","200");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
