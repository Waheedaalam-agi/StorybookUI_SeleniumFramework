package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDBData_modi {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Make sure we have database dependency in POM.XML
        //Strings for the fields needed
        String url = ""; //local host id comes from mysql
        String username = "abc";
        String password = "123456";
        String query = ""; //test this in sql to make sure it runs

        // Load the driver
        Class.forName("");

        // Create a connection with a database
        Connection con = DriverManager.getConnection(url, username, password);

        // Create a statement object
        Statement stm = con.createStatement();

        //execute query
        stm.executeUpdate(query);
        System.out.println("DONE...");

        //Close out all the connections (con obj, stm obj, rs obj)
        con.close();
        stm.close();
    }
}