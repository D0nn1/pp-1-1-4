package jm.task.core.jdbc.util;

import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;


public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


//    public static SessionFactory getFactory() {
//        SessionFactory sessionFactory = null;
//        try {
//            Configuration configuration = new Configuration();
//
//            Properties settings = new Properties();
//            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//            settings.put(Environment.URL, (URL + "?useSSL=false"));
//            settings.put(Environment.USER, USERNAME);
//            settings.put(Environment.PASS, PASSWORD);
//            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//            settings.put(Environment.SHOW_SQL, "true");
//
//            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//            settings.put(Environment.HBM2DDL_AUTO, "");
//
//            configuration.setProperties(settings);
//
//            configuration.addAnnotatedClass(User.class);
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (Exception e) {
//            System.out.println("Util exception");
//            e.printStackTrace();
//        }
//
//        return sessionFactory;
//
//
//    }


}
