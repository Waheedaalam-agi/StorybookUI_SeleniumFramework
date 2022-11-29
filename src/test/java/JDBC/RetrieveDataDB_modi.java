package JDBC;

//import java.sql.*;

public class RetrieveDataDB_modi {

    /**  public Connection establishDatabaseConnection() throws ClassNotFoundException, SQLException {
     String username = "";
     String password = "";
     String url = "";
     Connection connection = null;

     try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     connection = DriverManager.getConnection("", "", "");

     } catch (Exception e) {
     System.out.println(e.getStackTrace());
     connection.close();

     }

     return connection;
     }

     public ResultSet getQueryResult(String query) throws SQLException, ClassNotFoundException {
     Connection connection = establishDatabaseConnection();
     ResultSet rs = null;
     Statement statement = connection.createStatement();
     rs = statement.executeQuery(query);
     return rs;
     }

     public void updateQuery(String query) throws SQLException, ClassNotFoundException {
     Connection connection = establishDatabaseConnection();
     Statement statement = connection.createStatement();
     statement.executeUpdate(query);
     }*/
}