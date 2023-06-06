package co.edu.sena.project2687351.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicConnectionSingleton {
    private static String URL = "jdbc:mysql://localhost:3306/myapp?serverTimezone=America/Bogota";
    private static String USER = "1";
    private static String PASS = "1234";
    String username = "root";
    String password = "123456";
    private static Connection conn;
    public static Connection getInstance()
            throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        return conn;
    }
} // BasicConnectionSingleton
