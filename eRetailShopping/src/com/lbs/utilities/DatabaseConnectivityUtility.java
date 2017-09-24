package com.lbs.utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivityUtility {

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
       
       Connection con=null;
       String userName = "sa";
       String password = "password-1";
       String url = "jdbc:sqlserver://localhost:1433"+";databaseName=RetailDatabase";
       try{
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          con=DriverManager.getConnection(url,userName,password);
       }
       catch(Exception e){
           e.printStackTrace();
       }
        return con;
       
   }

    public static void closeConnection(Connection con) throws SQLException {
       con.close();
    }
}
