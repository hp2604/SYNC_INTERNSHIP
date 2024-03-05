
package com.syn_intern.connection;

import java.sql.*;


public class database_connection {
    private static Connection con;
    public static Connection getConnection(){
        if(con==null)
        {
           try {
            String username="root";
            String pass="Harsh2604";
            String url="jdbc:mysql://localhost:3306/feedback";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, username, pass);
     
            } 
           catch (Exception e) 
           {
                 e.printStackTrace();
           }    
        }
        
        return con;
    }
    
}
