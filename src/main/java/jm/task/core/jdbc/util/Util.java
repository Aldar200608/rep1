package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(User.class);
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // Укажите диалект для вашей БД
                configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Автоматическая генерация таблиц
                configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver"); // Драйвер
                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/my_database"); // URL базы данных
                configuration.setProperty("hibernate.connection.username", "postgres"); // Имя пользователя
                configuration.setProperty("hibernate.connection.password", "Radlasand_200608"); // Пароль
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {e.printStackTrace();}
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }


//    private static final String URL = "jdbc:postgresql://localhost:5432/my_database";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "Radlasand_200608";
//
//    public static Connection getConnection()throws SQLException {
//        return DriverManager.getConnection(URL,USER,PASSWORD);
//    }
}
