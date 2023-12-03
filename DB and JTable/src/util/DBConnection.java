package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection connect(){
        Connection connection = null;
        final String URL = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
