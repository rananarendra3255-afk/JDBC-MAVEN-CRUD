package demo;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "rana@01";

            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
