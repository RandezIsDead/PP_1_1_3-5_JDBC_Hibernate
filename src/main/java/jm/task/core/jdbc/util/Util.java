package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static final String USER_NAME = "randez";
    public static final String USER_PASSWORD = "qweqwe987nbsplvnfx";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }
}
