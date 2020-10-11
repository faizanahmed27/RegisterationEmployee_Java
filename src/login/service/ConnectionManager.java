package login.service;

import java.sql.*;



public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
       //  String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("com.mysql.jdbc.Driver");
         
         try
         {            	
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_page","root","root"); 
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              //"jdbc:mysql://localhost:3306/sonoo","root","root
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}