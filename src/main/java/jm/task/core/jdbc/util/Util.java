package jm.task.core.jdbc.util;

import java.sql.*;

public class Util{
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException{
         return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public static Statement getStatement() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD).createStatement();
    }



}
